package com.store.ccsc.module.system.dal.mysql.tongfuProject;


import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.mybatis.core.mapper.BaseMapperX;
import com.store.ccsc.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.store.ccsc.module.system.controller.admin.tongfuProject.query.TongFuProjectQueryVO;
import com.store.ccsc.module.system.controller.admin.tongfuProject.vo.TongFuProjectPageReqVO;
import com.store.ccsc.module.system.dal.dataobject.tongfuProject.TongFuProjectDO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


/**
 * 通服项目 Mapper
 *
 * @author 张明明
 */
@Mapper
public interface TongFuProjectMapper extends BaseMapperX<TongFuProjectDO> {

    // 项目结项状态
    final List<String> projectClosureStatusList = Arrays.asList("立项已完成", "项目过程已完结");
    // 专业类型名称
    final List<String> professionalTypeNameList = Arrays.asList(
            "工程施工-管线工程-通信线路施工-线路",
            "工程施工-设备工程-通信设备安装调试-基站",
            "工程施工-设备工程-通信设备安装调试-室内分布");

    final List<String> outsourcedWagesList = Arrays.asList(
            "工程施工-设备工程-通信设备安装调试-电源",
            "工程施工-设备工程-通信设备安装调试-数据",
            "工程施工-设备工程-通信设备安装调试-传输",
            "工程施工-设备工程-通信设备安装调试-接入",
            "工程施工-设备工程-通信设备安装调试-交换",
            "工程施工-设备工程-通信设备安装调试-综合",
            "工程施工-设备工程-通信设备安装调试-传输-波分",
            "工程施工-设备工程-通信设备安装调试-数据-网络其他设备",
            "工程施工-设备工程-通信设备安装调试-电源-通信机房电源",
            "工程施工-设备工程-通信设备安装调试-数据-网络交换设备",
            "工程施工-设备工程-通信设备安装调试-传输-数字"
    );



    default PageResult<TongFuProjectDO> selectPage(TongFuProjectPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode, reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName, reqVO.getCustomerName())
                .likeIfPresent(TongFuProjectDO::getEngineeringNo, reqVO.getEngineeringNo())
                .likeIfPresent(TongFuProjectDO::getProjectManager, reqVO.getProjectManager())
                .likeIfPresent(TongFuProjectDO::getOperator, reqVO.getOperator())
                .orderByDesc(TongFuProjectDO::getId));
    }

    default TongFuProjectDO selectByTfsProjectCode(String tfsProjectCode){
        return selectOne(new LambdaQueryWrapperX<TongFuProjectDO>().eqIfPresent(TongFuProjectDO::getTfsProjectCode,tfsProjectCode));
    }



    /**
     * 可直接付款分页
     */
    default PageResult<TongFuProjectDO> directPayable(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .gt(TongFuProjectDO::getTotalReceivedTax, BigDecimal.ZERO)
                .gt(TongFuProjectDO::getTotalInvoiceReceivedTax, BigDecimal.ZERO)
                .apply("total_paid_tax < total_invoice_received_tax")
                .orderByDesc(TongFuProjectDO::getId));
    }

    /**
     * 可收款分页
     */
    default PageResult<TongFuProjectDO> accountReceivable(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .gt(TongFuProjectDO::getTotalInvoicedTax, BigDecimal.ZERO)
                .apply("total_received_tax < total_invoiced_tax")
                .orderByDesc(TongFuProjectDO::getId));


    }

    /**
     * 可收票分页
     */
    default PageResult<TongFuProjectDO> acceptableInvoicing(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .in(TongFuProjectDO::getProfessionalTypeName,professionalTypeNameList)
                .gt(TongFuProjectDO::getTotalReceivedTax, BigDecimal.ZERO)
                .apply("actual_outsourcing_cost < outsourcing_cost")
                .orderByDesc(TongFuProjectDO::getId));
    }

    /**
     * 可外包工资分页
     */
    default PageResult<TongFuProjectDO> outsourcedWages(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .in(TongFuProjectDO::getProfessionalTypeName,outsourcedWagesList)
                .gt(TongFuProjectDO::getTotalReceivedTax, BigDecimal.ZERO)
                .apply("actual_outsourcing_cost < outsourcing_cost")
                .orderByDesc(TongFuProjectDO::getId));
    }


    /**
     * 5可进取
     */
    default PageResult<TongFuProjectDO> incomeReceivable(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .apply("total_invoiced_no_tax - record_income_no_tax > 1")
                .orderByDesc(TongFuProjectDO::getId));
    }


    /**
     * 6需退收
     */
    default PageResult<TongFuProjectDO> refundRequired(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .gt(TongFuProjectDO::getTotalInvoicedTax, BigDecimal.ZERO)
                .apply("total_invoiced_no_tax - record_income_no_tax < -1")
                .orderByDesc(TongFuProjectDO::getId));
    }


    /**
     * 7可开票
     */
    default PageResult<TongFuProjectDO> invoicingAvailable(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .apply("record_income_no_tax > total_invoiced_no_tax")
                .orderByDesc(TongFuProjectDO::getId));
    }


    /**
     * 0进取
     */
    default PageResult<TongFuProjectDO> zeroIncome(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .eq(TongFuProjectDO::getRecordIncomeNoTax, BigDecimal.ZERO)
                .orderByDesc(TongFuProjectDO::getId));
    }


    /**
     * 9可分包
     */
    default PageResult<TongFuProjectDO> subcontractable(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .gt(TongFuProjectDO::getTotalReceivedTax, BigDecimal.ZERO)
                .apply("outsourcing_cost > actual_outsourcing_cost")
                .orderByDesc(TongFuProjectDO::getId));
    }

    /**
     * 10可用人工
     */
    default PageResult<TongFuProjectDO> manpowerAvailable(TongFuProjectQueryVO reqVO){
        return selectPage(reqVO, new LambdaQueryWrapperX<TongFuProjectDO>()
                .likeIfPresent(TongFuProjectDO::getTfsProjectCode,reqVO.getTfsProjectCode())
                .likeIfPresent(TongFuProjectDO::getCustomerName,reqVO.getCustomerName())
                .in(TongFuProjectDO::getProjectClosureStatus,projectClosureStatusList)
                .and(vo->vo.gt(TongFuProjectDO::getActualMaterialCost, BigDecimal.ZERO).or().gt(TongFuProjectDO::getActualLaborCost, BigDecimal.ZERO))
                .gt(TongFuProjectDO::getContractIncomeNoTax, BigDecimal.ZERO)
                .orderByDesc(TongFuProjectDO::getId));
    }
}