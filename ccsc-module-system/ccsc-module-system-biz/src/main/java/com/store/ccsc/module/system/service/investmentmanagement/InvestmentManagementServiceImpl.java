package com.store.ccsc.module.system.service.investmentmanagement;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.common.util.object.BeanUtils;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementExcelVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementImportRespVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementPageReqVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementSaveReqVO;
import com.store.ccsc.module.system.dal.dataobject.investmentmanagement.InvestmentManagementDO;
import com.store.ccsc.module.system.dal.mysql.investmentmanagement.InvestmentManagementMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.store.ccsc.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.store.ccsc.module.system.enums.ErrorCodeConstants.*;


/**
 * 工程投资管理 Service 实现类
 *
 * @author 张明明
 */
@Slf4j
@Service
@Validated
public class InvestmentManagementServiceImpl extends ServiceImpl<InvestmentManagementMapper,InvestmentManagementDO> implements InvestmentManagementService {

    @Resource
    private InvestmentManagementMapper investmentManagementMapper;

    @Override
    public Long createInvestmentManagement(InvestmentManagementSaveReqVO createReqVO) {
        // 插入
        InvestmentManagementDO investmentManagement = BeanUtils.toBean(createReqVO, InvestmentManagementDO.class);
        investmentManagement.setBatchNumber("9999");
        investmentManagement.setAuditStatus("0");
        investmentManagementMapper.insert(investmentManagement);
        // 返回
        return investmentManagement.getId();
    }

    @Override
    public void updateInvestmentManagement(InvestmentManagementSaveReqVO updateReqVO) {
        // 校验存在
        validateInvestmentManagementExists(updateReqVO.getId());
        // 更新
        InvestmentManagementDO updateObj = BeanUtils.toBean(updateReqVO, InvestmentManagementDO.class);
        investmentManagementMapper.updateById(updateObj);
    }

    @Override
    public void deleteInvestmentManagement(Long id) {
        // 校验存在
        validateInvestmentManagementExists(id);
        // 删除
        investmentManagementMapper.deleteById(id);
    }

    private void validateInvestmentManagementExists(Long id) {
        if (investmentManagementMapper.selectById(id) == null) {
            exception(INVESTMENT_MANAGEMENT_NOT_EXISTS);
        }
    }

    @Override
    public InvestmentManagementDO getInvestmentManagement(Long id) {
        return investmentManagementMapper.selectById(id);
    }

    @Override
    public PageResult<InvestmentManagementDO> getInvestmentManagementPage(InvestmentManagementPageReqVO pageReqVO) {
        return investmentManagementMapper.selectPage(pageReqVO);
    }

    @Override
    public InvestmentManagementImportRespVO importInvestmentManagementList(List<InvestmentManagementExcelVO> investmentManagementList, Boolean updateSupport) {
        if (CollUtil.isEmpty(investmentManagementList)) {
            throw exception(INVESTMENT_MANAGEMENT_IMPORT_LIST_IS_EMPTY);
        }
        InvestmentManagementImportRespVO respVO = InvestmentManagementImportRespVO.builder().createNames(new ArrayList<>())
                                                   .updateNames(new ArrayList<>()).failureNames(new LinkedHashMap<>()).build();
        String batchNumber = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        investmentManagementList.forEach(importInvestment -> {
            final InvestmentManagementDO existInvestmentManagementDO = investmentManagementMapper.selectByEngineeringNo(importInvestment.getEngineeringNo());
            final InvestmentManagementDO bean = BeanUtils.toBean(importInvestment, InvestmentManagementDO.class);
            bean.setAuditStatus("0");
            if (updateSupport) { // 允许更新
                if (existInvestmentManagementDO != null) {
                    bean.setId(existInvestmentManagementDO.getId());
                    bean.setBatchNumber(batchNumber);
                    investmentManagementMapper.updateById(bean);
                    respVO.getUpdateNames().add(importInvestment.getEngineeringNo());
                }else{
                    insertNewRecords(bean, batchNumber, respVO);
                }
            }else{ // 不允许更新,只能添加。
                if (existInvestmentManagementDO != null) {
                    respVO.getFailureNames().put(importInvestment.getEngineeringNo(), INVESTMENT_MANAGEMENT_EXISTS.getMsg());
                }else{
                    insertNewRecords(bean, batchNumber, respVO);
                }
            }
        });
        return respVO;
    }

    private void insertNewRecords(InvestmentManagementDO bean, String batchNumber, InvestmentManagementImportRespVO respVO) {
        bean.setBatchNumber(batchNumber);
        investmentManagementMapper.insert(bean);
        respVO.getCreateNames().add(bean.getEngineeringNo());
    }

    @Override
    public List<String> getBatchNumberList() {
        LambdaQueryWrapper<InvestmentManagementDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.isNotNull(InvestmentManagementDO::getBatchNumber);
        final List<InvestmentManagementDO> selectList = investmentManagementMapper.selectList(queryWrapper);
        if (CollectionUtil.isNotEmpty(selectList)) {
            return selectList.stream().map(InvestmentManagementDO::getBatchNumber).filter(StringUtils::isNotEmpty).distinct().collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> getEngineeringStatusList() {
        final List<InvestmentManagementDO> list = this.list();
        if (CollectionUtil.isNotEmpty(list)) {
            return list.stream().map(InvestmentManagementDO::getEngineeringStatus).filter(StringUtils::isNotEmpty).distinct().toList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> getFirstLevelMajorList() {
        final List<InvestmentManagementDO> list = this.list();
        if (CollectionUtil.isNotEmpty(list)) {
            return list.stream().map(InvestmentManagementDO::getFirstLevelMajor).filter(StringUtils::isNotEmpty).distinct().toList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> getConstructionCompanyList() {
        final List<InvestmentManagementDO> list = this.list();
        if (CollectionUtil.isNotEmpty(list)) {
            return list.stream().map(InvestmentManagementDO::getConstructionCompany).filter(StringUtils::isNotEmpty).distinct().toList();
        }
        return new ArrayList<>();
    }

    @Override
    public InvestmentManagementDO getByEngineeringNo(String engineeringNo) {
        LambdaQueryWrapper<InvestmentManagementDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(InvestmentManagementDO::getEngineeringNo, engineeringNo);
        return investmentManagementMapper.selectOne(queryWrapper);
    }


}