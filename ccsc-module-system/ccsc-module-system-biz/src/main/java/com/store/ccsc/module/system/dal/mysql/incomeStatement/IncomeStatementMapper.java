package com.store.ccsc.module.system.dal.mysql.incomeStatement;

import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.mybatis.core.mapper.BaseMapperX;
import com.store.ccsc.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.store.ccsc.module.system.controller.admin.incomeStatement.vo.IncomeStatementPageReqVO;
import com.store.ccsc.module.system.dal.dataobject.incomeStatement.IncomeStatementDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 收入清单 Mapper
 *
 * @author zhangmingming
 */
@Mapper
public interface IncomeStatementMapper extends BaseMapperX<IncomeStatementDO> {

    default PageResult<IncomeStatementDO> selectPage(IncomeStatementPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IncomeStatementDO>()
                .likeIfPresent(IncomeStatementDO::getEngineeringNo, reqVO.getEngineeringNo())
                .likeIfPresent(IncomeStatementDO::getTfsProjectCode, reqVO.getTfsProjectCode())
                .likeIfPresent(IncomeStatementDO::getProjectManager, reqVO.getProjectManager())
                .orderByDesc(IncomeStatementDO::getId));
    }

    /**
     *
     * @param tongFuProjectId
     * @return
     */
    IncomeStatementDO getIncomeStatementData(Long tongFuProjectId);
}