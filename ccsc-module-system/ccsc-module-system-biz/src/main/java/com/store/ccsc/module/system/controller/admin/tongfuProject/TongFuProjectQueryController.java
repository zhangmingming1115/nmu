package com.store.ccsc.module.system.controller.admin.tongfuProject;

import com.store.ccsc.framework.common.pojo.CommonResult;
import com.store.ccsc.framework.common.pojo.PageParam;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.excel.core.util.ExcelUtils;
import com.store.ccsc.module.system.controller.admin.tongfuProject.query.*;
import com.store.ccsc.module.system.service.tongfuProjectQuery.TongfuProjectQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.store.ccsc.framework.common.pojo.CommonResult.success;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/13/013 17:07
 * @Description:
 */
@Tag(name = "管理后台 - 通服项目查询")
@RestController
@RequestMapping("/tongfu/tongFuProjectQuery")
public class TongFuProjectQueryController {

    @Resource
    private TongfuProjectQueryService service;

    @GetMapping("/directPayable")
    @Operation(summary = "1可付款")
    @PreAuthorize("@ss.hasPermission('tongfu:tongFuProjectQuery:query')")
    public CommonResult<PageResult<DirectPayableResultVo>> directPayable(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<DirectPayableResultVo> pageResult = service.directPayable(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/directPayableExport")
    public void directPayableExport(TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<DirectPayableResultVo> list = service.directPayable(pageReqVO).getList();
        ExcelUtils.write(response, "可直接付款.xls", "可直接付款", DirectPayableResultVo.class,list);
    }





    /**
     * 可收款
     * @param pageReqVO
     */
    @GetMapping("/accountReceivable")
    @Operation(summary = "2可收款")
    @PreAuthorize("@ss.hasPermission('tongfu:tongFuProjectQuery:query')")
    public CommonResult<PageResult<AccountReceivableResultVo>> accountReceivable(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<AccountReceivableResultVo> pageResult = service.accountReceivable(pageReqVO);
        return success(pageResult);
    }
    @GetMapping("/accountReceivableExport")
    public void accountReceivableExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<AccountReceivableResultVo> list = service.accountReceivable(pageReqVO).getList();
        ExcelUtils.write(response, "可收款.xls", "可收款", AccountReceivableResultVo.class,list);
    }




    @GetMapping("/acceptableInvoicing")
    @Operation(summary = "3可收票")
    @PreAuthorize("@ss.hasPermission('tongfu:tongFuProjectQuery:query')")
    public CommonResult<PageResult<AcceptableInvoicingResultVo>> acceptableInvoicing(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<AcceptableInvoicingResultVo> pageResult = service.acceptableInvoicing(pageReqVO);
        return success(pageResult);
    }
    @GetMapping("/acceptableInvoicingExport")
    @PreAuthorize("@ss.hasPermission('tongfu:tongFuProjectQuery:query')")
    public void acceptableInvoicingExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<AcceptableInvoicingResultVo> list = service.acceptableInvoicing(pageReqVO).getList();
        ExcelUtils.write(response, "可收款.xls", "可收款", AcceptableInvoicingResultVo.class,list);
    }






    @GetMapping("/outsourcedWages")
    @Operation(summary = "4可外包工资")
    @PreAuthorize("@ss.hasPermission('tongfu:tongFuProjectQuery:query')")
    public CommonResult<PageResult<OutsourcedWagesResultVo>> outsourcedWages(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<OutsourcedWagesResultVo> pageResult = service.outsourcedWages(pageReqVO);
        return success(pageResult);
    }
    @GetMapping("/outsourcedWagesExport")
    @PreAuthorize("@ss.hasPermission('tongfu:tongFuProjectQuery:query')")
    public void outsourcedWagesExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<OutsourcedWagesResultVo> list = service.outsourcedWages(pageReqVO).getList();
        ExcelUtils.write(response, "可外包工资.xls", "可外包工资", OutsourcedWagesResultVo.class,list);
    }


    @GetMapping("/incomeReceivable")
    @Operation(summary = "5可进取")
    public CommonResult<PageResult<IncomeReceivableResultVo>> incomeReceivable(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<IncomeReceivableResultVo> pageResult = service.incomeReceivable(pageReqVO);
        return success(pageResult);
    }
    @GetMapping("/incomeReceivableExport")
    public void incomeReceivableExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<IncomeReceivableResultVo> list = service.incomeReceivable(pageReqVO).getList();
        ExcelUtils.write(response, "可进取.xls", "可进取", IncomeReceivableResultVo.class,list);
    }




    @GetMapping("/refundRequired")
    @Operation(summary = "6需退收")
    public CommonResult<PageResult<RefundRequiredResultVo>> refundRequired(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<RefundRequiredResultVo> pageResult = service.refundRequired(pageReqVO);
        return success(pageResult);
    }
    @GetMapping("/refundRequiredExport")
    public void refundRequiredExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<RefundRequiredResultVo> list = service.refundRequired(pageReqVO).getList();
        ExcelUtils.write(response, "需退收.xls", "需退收", RefundRequiredResultVo.class,list);
    }




    @GetMapping("/invoicingAvailable")
    @Operation(summary = "7可开票")
    public CommonResult<PageResult<InvoicingAvailableResultVo>> invoicingAvailable(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<InvoicingAvailableResultVo> pageResult = service.invoicingAvailable(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/invoicingAvailableExport")
    public void invoicingAvailableExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<InvoicingAvailableResultVo> list = service.invoicingAvailable(pageReqVO).getList();
        ExcelUtils.write(response, "可开票.xls", "可开票", InvoicingAvailableResultVo.class,list);
    }



    @GetMapping("/zeroIncome")
    @Operation(summary = "8零进取")
    public CommonResult<PageResult<ZeroIncomeResultVo>> zeroIncome(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<ZeroIncomeResultVo> pageResult = service.zeroIncome(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/zeroIncomeExport")
    public void zeroIncomeExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<ZeroIncomeResultVo> list = service.zeroIncome(pageReqVO).getList();
        ExcelUtils.write(response, "零进取.xls", "零进取", ZeroIncomeResultVo.class,list);
    }



    @GetMapping("/subcontractable")
    @Operation(summary = "9可分包")
    public CommonResult<PageResult<SubcontractableResultVo>> subcontractable(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<SubcontractableResultVo> pageResult = service.subcontractable(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/subcontractableExport")
    public void subcontractableExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<SubcontractableResultVo> list = service.subcontractable(pageReqVO).getList();
        ExcelUtils.write(response, "可分包.xls", "可分包", SubcontractableResultVo.class,list);
    }



    @GetMapping("/manpowerAvailable")
    @Operation(summary = "10可用人工")
    public CommonResult<PageResult<ManpowerAvailableResultVo>> manpowerAvailable(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<ManpowerAvailableResultVo> pageResult = service.manpowerAvailable(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/manpowerAvailableExport")
    public void manpowerAvailableExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<ManpowerAvailableResultVo> list = service.manpowerAvailable(pageReqVO).getList();
        ExcelUtils.write(response, "可用人工.xls", "可用人工", ManpowerAvailableResultVo.class,list);
    }


    @GetMapping("/availableOtherExpenses")
    @Operation(summary = "12 可用其他费")
    public CommonResult<PageResult<AvailableOtherExpensesResultVo>> availableOtherExpenses(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<AvailableOtherExpensesResultVo> pageResult = service.availableOtherExpenses(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/availableOtherExpensesExport")
    public void availableOtherExpensesExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<AvailableOtherExpensesResultVo> list = service.availableOtherExpenses(pageReqVO).getList();
        ExcelUtils.write(response, "可用其他费.xls", "可用其他费", AvailableOtherExpensesResultVo.class,list);
    }


    @GetMapping("/availableMaterialCosts")
    @Operation(summary = "13 可用材料费")
    public CommonResult<PageResult<AvailableMaterialCostsResultVo>> availableMaterialCosts(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<AvailableMaterialCostsResultVo> pageResult = service.availableMaterialCosts(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/availableMaterialCostsExport")
    public void availableMaterialCostsExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<AvailableMaterialCostsResultVo> list = service.availableMaterialCosts(pageReqVO).getList();
        ExcelUtils.write(response, "可用材料费.xls", "可用材料费", AvailableMaterialCostsResultVo.class,list);
    }



    @GetMapping("/paymentCollectionVariance")
    @Operation(summary = "14 回款差异")
    public CommonResult<PageResult<PaymentCollectionVarianceResultVo>> paymentCollectionVariance(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<PaymentCollectionVarianceResultVo> pageResult = service.paymentCollectionVariance(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/paymentCollectionVarianceExport")
    public void paymentCollectionVarianceExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<PaymentCollectionVarianceResultVo> list = service.paymentCollectionVariance(pageReqVO).getList();
        ExcelUtils.write(response, "回款差异.xls", "回款差异", PaymentCollectionVarianceResultVo.class,list);
    }



    @GetMapping("/highPlannedRevenue")
    @Operation(summary = "15 计划收入大")
    public CommonResult<PageResult<HighPlannedRevenueResultVo>> highPlannedRevenue(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<HighPlannedRevenueResultVo> pageResult = service.highPlannedRevenue(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/highPlannedRevenueExport")
    public void highPlannedRevenueExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<HighPlannedRevenueResultVo> list = service.highPlannedRevenue(pageReqVO).getList();
        ExcelUtils.write(response, "计划收入大.xls", "计划收入大", HighPlannedRevenueResultVo.class,list);
    }



    @GetMapping("/closable")
    @Operation(summary = "16 可关闭")
    public CommonResult<PageResult<ClosableResultVo>> closable(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<ClosableResultVo> pageResult = service.closable(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/closableExport")
    public void closableExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<ClosableResultVo> list = service.closable(pageReqVO).getList();
        ExcelUtils.write(response, "可关闭.xls", "可关闭", ClosableResultVo.class,list);
    }



    @GetMapping("/lowPlannedRevenue")
    @Operation(summary = "17 计划收入小")
    public CommonResult<PageResult<LowPlannedRevenueResultVo>> lowPlannedRevenue(@Valid TongFuProjectQueryVO pageReqVO) {
        PageResult<LowPlannedRevenueResultVo> pageResult = service.lowPlannedRevenue(pageReqVO);
        return success(pageResult);
    }

    @GetMapping("/lowPlannedRevenueExport")
    public void lowPlannedRevenueExport(@Valid TongFuProjectQueryVO pageReqVO, HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        final List<LowPlannedRevenueResultVo> list = service.lowPlannedRevenue(pageReqVO).getList();
        ExcelUtils.write(response, "计划收入小.xls", "计划收入小", LowPlannedRevenueResultVo.class,list);
    }







}
