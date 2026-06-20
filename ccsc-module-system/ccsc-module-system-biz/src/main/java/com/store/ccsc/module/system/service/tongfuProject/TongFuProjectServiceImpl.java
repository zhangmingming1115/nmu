package com.store.ccsc.module.system.service.tongfuProject;

import cn.hutool.core.collection.CollUtil;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.common.util.object.BeanUtils;
import com.store.ccsc.module.system.controller.admin.tongfuProject.vo.*;
import com.store.ccsc.module.system.dal.dataobject.incomeStatement.IncomeStatementDO;
import com.store.ccsc.module.system.dal.dataobject.tongfuProject.TongFuProjectDO;
import com.store.ccsc.module.system.dal.mysql.incomeStatement.IncomeStatementMapper;
import com.store.ccsc.module.system.dal.mysql.tongfuProject.TongFuProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.store.ccsc.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.store.ccsc.module.system.enums.ErrorCodeConstants.*;

/**
 * 通服项目 Service 实现类
 *
 * @author 张明明
 */
@Service
@Validated
public class TongFuProjectServiceImpl implements TongFuProjectService {

    @Resource
    private TongFuProjectMapper tongFuProjectMapper;

    @Resource
    private IncomeStatementMapper incomeStatementMapper;

    @Override
    public Long createTongFuProject(TongFuProjectSaveReqVO createReqVO) {
        // 插入
        TongFuProjectDO tongFuProject = BeanUtils.toBean(createReqVO, TongFuProjectDO.class);
        tongFuProjectMapper.insert(tongFuProject);
        // 返回
        return tongFuProject.getId();
    }

    @Override
    public void updateTongFuProject(TongFuProjectSaveReqVO updateReqVO) {
        // 校验存在
        validateTongFuProjectExists(updateReqVO.getId());
        // 更新
        TongFuProjectDO updateObj = BeanUtils.toBean(updateReqVO, TongFuProjectDO.class);
        tongFuProjectMapper.updateById(updateObj);
    }

    @Override
    public void deleteTongFuProject(Long id) {
        // 校验存在
        validateTongFuProjectExists(id);
        // 删除
        tongFuProjectMapper.deleteById(id);
    }

    private void validateTongFuProjectExists(Long id) {
        if (tongFuProjectMapper.selectById(id) == null) {
            throw exception(TONG_FU_PROJECT_NOT_EXISTS);
        }
    }

    @Override
    public TongFuProjectDO getTongFuProject(Long id) {
        return tongFuProjectMapper.selectById(id);
    }

    @Override
    public PageResult<TongFuProjectDO> getTongFuProjectPage(TongFuProjectPageReqVO pageReqVO) {
        return tongFuProjectMapper.selectPage(pageReqVO);
    }

    @Override
    public IncomeStatementDO getIncomeStatementData(Long tongFuProjectId) {
        return incomeStatementMapper.getIncomeStatementData(tongFuProjectId);
    }

    @Override
    public TongFuProjectImportRespVO importTongFuProjectList(List<TongFuProjectExcelVO> list, Boolean updateSupport) {
        if (CollUtil.isEmpty(list)) {
            throw exception(TONG_FU_PROJECT_IMPORT_LIST_IS_EMPTY);
        }
        TongFuProjectImportRespVO respVO = TongFuProjectImportRespVO.builder().createNames(new ArrayList<>())
                                                                                  .updateNames(new ArrayList<>()).failureNames(new LinkedHashMap<>()).build();
        String batchNumber = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        list.forEach(excelVO -> {
            final TongFuProjectDO tongFuProjectDO = tongFuProjectMapper.selectByTfsProjectCode(excelVO.getTfsProjectCode());
            final TongFuProjectDO excelBean = BeanUtils.toBean(excelVO, TongFuProjectDO.class);
            if (updateSupport) { // 允许更新
                if (tongFuProjectDO != null) {
                    excelBean.setId(tongFuProjectDO.getId());
                    excelBean.setBatchNumber(batchNumber);
                    tongFuProjectMapper.updateById(excelBean);
                    respVO.getUpdateNames().add(excelBean.getTfsProjectCode());
                }else{
                    insertNewRecords(excelBean, batchNumber, respVO);
                }
            }else{ // 不允许更新,只能添加。
                if (tongFuProjectDO != null) {
                    respVO.getFailureNames().put(excelBean.getTfsProjectCode(), TONG_FU_PROJECT_EXISTS.getMsg());
                }else{
                    insertNewRecords(excelBean, batchNumber, respVO);
                }
            }
        });
        return respVO;
    }




    private void insertNewRecords(TongFuProjectDO bean, String batchNumber, TongFuProjectImportRespVO respVO) {
        bean.setBatchNumber(batchNumber);
        tongFuProjectMapper.insert(bean);
        respVO.getCreateNames().add(bean.getTfsProjectCode());
    }




}