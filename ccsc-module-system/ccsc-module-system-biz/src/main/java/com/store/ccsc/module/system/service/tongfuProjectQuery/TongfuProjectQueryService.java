package com.store.ccsc.module.system.service.tongfuProjectQuery;

import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.module.system.controller.admin.tongfuProject.query.*;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/13/013 17:19
 * @Description:
 */
public interface TongfuProjectQueryService {

    /**
     * 可直接付款分页
     */
    PageResult<DirectPayableResultVo> directPayable(TongFuProjectQueryVO pageReqVO);


    /**
     * 可收款
     */
    PageResult<AccountReceivableResultVo> accountReceivable(TongFuProjectQueryVO pageReqVO);

    /**
     * 可收票分页
     */
    PageResult<AcceptableInvoicingResultVo> acceptableInvoicing(TongFuProjectQueryVO pageReqVO);

    /**
     * 可外包工资分页
     */
    PageResult<OutsourcedWagesResultVo> outsourcedWages(TongFuProjectQueryVO pageReqVO);


    /**
     * 可进取
     */
    PageResult<IncomeReceivableResultVo> incomeReceivable(TongFuProjectQueryVO pageReqVO);

    /**
     * 6 需退收
     */
    PageResult<RefundRequiredResultVo> refundRequired(TongFuProjectQueryVO pageReqVO);

    /**
     * 7可开票
     */
    PageResult<InvoicingAvailableResultVo> invoicingAvailable(TongFuProjectQueryVO pageReqVO);

    /**
     * 8零进取
     */
    PageResult<ZeroIncomeResultVo> zeroIncome(TongFuProjectQueryVO pageReqVO);

    /**
     * 9可分包
     */
    PageResult<SubcontractableResultVo> subcontractable(TongFuProjectQueryVO pageReqVO);

    /**
     * 10可用人工
     */
    PageResult<ManpowerAvailableResultVo> manpowerAvailable(TongFuProjectQueryVO pageReqVO);

    /**
     * 12 可用其他费
     */
    PageResult<AvailableOtherExpensesResultVo> availableOtherExpenses(TongFuProjectQueryVO pageReqVO);

    /**
     * 13 可用材料费
     */
    PageResult<AvailableMaterialCostsResultVo> availableMaterialCosts(TongFuProjectQueryVO pageReqVO);

    /**
     * 14 回款差异
     */
    PageResult<PaymentCollectionVarianceResultVo> paymentCollectionVariance(TongFuProjectQueryVO pageReqVO);

    /**
     * 15 计划收入大
     */
    PageResult<HighPlannedRevenueResultVo> highPlannedRevenue(TongFuProjectQueryVO pageReqVO);

    /**
     * 16 可关闭
     */
    PageResult<ClosableResultVo> closable(TongFuProjectQueryVO pageReqVO);

    /**
     * 17 计划收入小
     */
    PageResult<LowPlannedRevenueResultVo> lowPlannedRevenue(TongFuProjectQueryVO pageReqVO);
}
