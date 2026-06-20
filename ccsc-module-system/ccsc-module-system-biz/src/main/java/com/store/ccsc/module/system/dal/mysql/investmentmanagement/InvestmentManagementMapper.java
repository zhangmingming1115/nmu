package com.store.ccsc.module.system.dal.mysql.investmentmanagement;

import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.mybatis.core.mapper.BaseMapperX;
import com.store.ccsc.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementPageReqVO;
import com.store.ccsc.module.system.dal.dataobject.investmentmanagement.InvestmentManagementDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 工程投资管理 Mapper
 *
 * @author 张明明
 */
@Mapper
public interface InvestmentManagementMapper extends BaseMapperX<InvestmentManagementDO> {

    default PageResult<InvestmentManagementDO> selectPage(InvestmentManagementPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<InvestmentManagementDO>()
                .eqIfPresent(InvestmentManagementDO::getAuditStatus,reqVO.getAuditStatus())
                .likeIfPresent(InvestmentManagementDO::getEngineeringNo, reqVO.getEngineeringNo())
                .likeIfPresent(InvestmentManagementDO::getEngineeringName, reqVO.getEngineeringName())
                .likeIfPresent(InvestmentManagementDO::getConstructionCompany, reqVO.getConstructionCompany())
                .likeIfPresent(InvestmentManagementDO::getEngineeringStatus, reqVO.getEngineeringStatus())
                .likeIfPresent(InvestmentManagementDO::getEngineeringManager, reqVO.getEngineeringManager())
                .likeIfPresent(InvestmentManagementDO::getFirstLevelMajor, reqVO.getFirstLevelMajor())
                .orderByDesc(InvestmentManagementDO::getId));
    }

    default InvestmentManagementDO selectByEngineeringNo(String engineeringNo){
        return selectOne(InvestmentManagementDO::getEngineeringNo, engineeringNo);
    }
}