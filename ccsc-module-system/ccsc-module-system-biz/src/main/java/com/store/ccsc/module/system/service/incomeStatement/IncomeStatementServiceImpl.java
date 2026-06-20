package com.store.ccsc.module.system.service.incomeStatement;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.common.util.object.BeanUtils;
import com.store.ccsc.module.system.controller.admin.incomeStatement.vo.IncomeStatementPageReqVO;
import com.store.ccsc.module.system.controller.admin.incomeStatement.vo.IncomeStatementSaveReqVO;
import com.store.ccsc.module.system.dal.dataobject.incomeStatement.IncomeStatementDO;
import com.store.ccsc.module.system.dal.dataobject.investmentmanagement.InvestmentManagementDO;
import com.store.ccsc.module.system.dal.mysql.incomeStatement.IncomeStatementMapper;
import com.store.ccsc.module.system.dal.mysql.investmentmanagement.InvestmentManagementMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import java.util.List;

import static com.store.ccsc.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.store.ccsc.module.system.enums.ErrorCodeConstants.*;

/**
 * 收入清单 Service 实现类
 *
 * @author zhangmingming
 */
@Service
@Validated
public class IncomeStatementServiceImpl extends ServiceImpl<IncomeStatementMapper, IncomeStatementDO> implements IncomeStatementService {

    @Resource
    private IncomeStatementMapper mapper;
    @Resource
    private InvestmentManagementMapper investmentManagementMapper;

    @Override
    public Long create(IncomeStatementSaveReqVO createReqVO) {
        // 插入
        IncomeStatementDO incomeStatementDO = BeanUtils.toBean(createReqVO, IncomeStatementDO.class);
        mapper.insert(incomeStatementDO);
        // 返回
        return incomeStatementDO.getId();
    }

    @Override
    public void update(IncomeStatementSaveReqVO updateReqVO) {
        // 校验存在
        validateExists(updateReqVO.getId());
        // 更新
        IncomeStatementDO updateObj = BeanUtils.toBean(updateReqVO, IncomeStatementDO.class);
        mapper.updateById(updateObj);
    }

    @Override
    public void delete(Long id) {
        // 校验存在
        validateExists(id);
        // 删除
        mapper.deleteById(id);
    }

    private void validateExists(Long id) {
        if (mapper.selectById(id) == null) {
            throw exception(INCOME_STATEMENT_NOT_EXISTS);
        }
    }

    @Override
    public IncomeStatementDO get(Long id) {
        final IncomeStatementDO statementDO = mapper.selectById(id);
        final InvestmentManagementDO managementDO = investmentManagementMapper.selectByEngineeringNo(statementDO.getEngineeringNo());
        statementDO.setEngineeringName(managementDO.getEngineeringName());
        statementDO.setEngineeringManager(managementDO.getEngineeringManager());
        statementDO.setConstructionCompany(managementDO.getConstructionCompany());
        return statementDO;
    }

    @Override
    public PageResult<IncomeStatementDO> getPage(IncomeStatementPageReqVO pageReqVO) {
        final PageResult<IncomeStatementDO> selectPage = mapper.selectPage(pageReqVO);
        final List<IncomeStatementDO> list = selectPage.getList();
        if (CollectionUtil.isNotEmpty(list)) {
            final List<IncomeStatementDO> collect = list.stream().peek(vo -> {
                final InvestmentManagementDO managementDO = investmentManagementMapper.selectByEngineeringNo(vo.getEngineeringNo());
                vo.setEngineeringName(managementDO.getEngineeringName());
                vo.setEngineeringManager(managementDO.getEngineeringManager());
                vo.setConstructionCompany(managementDO.getConstructionCompany());
            }).toList();
            selectPage.setList(collect);
        }
        return selectPage;
    }

}