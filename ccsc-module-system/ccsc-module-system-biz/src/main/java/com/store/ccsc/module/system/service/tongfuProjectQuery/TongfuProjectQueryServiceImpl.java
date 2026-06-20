package com.store.ccsc.module.system.service.tongfuProjectQuery;

import cn.hutool.core.bean.BeanUtil;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.module.system.controller.admin.tongfuProject.query.*;
import com.store.ccsc.module.system.dal.dataobject.tongfuProject.TongFuProjectDO;
import com.store.ccsc.module.system.dal.mysql.tongfuProject.TongFuProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/13/013 17:20
 * @Description:
 */
@Service
@Slf4j
public class TongfuProjectQueryServiceImpl implements TongfuProjectQueryService{

    @Resource
    private TongFuProjectMapper tongFuProjectMapper;


    @Override
    public PageResult<DirectPayableResultVo> directPayable(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.directPayable(pageReqVO);
        final List<DirectPayableResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            DirectPayableResultVo vo = new DirectPayableResultVo();
            vo.setDirectPayable(item.getTotalInvoiceReceivedTax().subtract(item.getTotalPaidTax()));
            BeanUtil.copyProperties(item, vo);
            return vo;
        }).toList();
        PageResult<DirectPayableResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }

    @Override
    public PageResult<AccountReceivableResultVo> accountReceivable(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.accountReceivable(pageReqVO);
        final List<AccountReceivableResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            AccountReceivableResultVo vo = new AccountReceivableResultVo();
//            totalInvoicedTax-totalReceivedTax
            vo.setAccountReceivable(item.getTotalInvoicedTax().subtract(item.getTotalReceivedTax()));
            BeanUtil.copyProperties(item, vo);
            return vo;
        }).toList();
        PageResult<AccountReceivableResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }



    @Override
    public PageResult<AcceptableInvoicingResultVo> acceptableInvoicing(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.acceptableInvoicing(pageReqVO);
        final List<AcceptableInvoicingResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            AcceptableInvoicingResultVo vo = new AcceptableInvoicingResultVo();
//             outsourcingCost - actualOutsourcingCost
            vo.setAcceptableInvoicing(item.getOutsourcingCost().subtract(item.getActualOutsourcingCost()));
            BeanUtil.copyProperties(item, vo);
            return vo;
        }).toList();
        PageResult<AcceptableInvoicingResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }

    @Override
    public PageResult<OutsourcedWagesResultVo> outsourcedWages(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.outsourcedWages(pageReqVO);
        final List<OutsourcedWagesResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            OutsourcedWagesResultVo vo = new OutsourcedWagesResultVo();
//            outsourcedWages = outsourcingCost - actualOutsourcingCost
            vo.setOutsourcedWages(item.getOutsourcingCost().subtract(item.getActualOutsourcingCost()));
            BeanUtil.copyProperties(item, vo);
            return vo;
        }).toList();
        PageResult<OutsourcedWagesResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }


    /**
     * 5可进取
     */
    @Override
    public PageResult<IncomeReceivableResultVo> incomeReceivable(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.incomeReceivable(pageReqVO);
        List<IncomeReceivableResultVo> resultList = payablePage.getList().stream().map(item -> {
                   IncomeReceivableResultVo vo = new IncomeReceivableResultVo();
                   BeanUtil.copyProperties(item, vo);
                   vo.setIncomeReceivable(item.getTotalInvoicedNoTax().subtract(item.getRecordIncomeNoTax())); // 计算：应收款 = 已开票不含税 - 已录收入不含税
                   return vo;
               }).toList();
        PageResult<IncomeReceivableResultVo> pageResult = new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(resultList);
        return pageResult;
    }



    /**
     * 6需退收
     */
    @Override
    public PageResult<RefundRequiredResultVo> refundRequired(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.refundRequired(pageReqVO);
        final List<RefundRequiredResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            RefundRequiredResultVo vo = new RefundRequiredResultVo();
            vo.setRefundRequired(item.getTotalInvoicedNoTax().subtract(item.getRecordIncomeNoTax()));  //  refundRequired = totalInvoicedNoTax - recordIncomeNoTax
            BeanUtil.copyProperties(item, vo);
            return vo;
        }).toList();
        PageResult<RefundRequiredResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }

    /**
     * 7可开票
     */
    @Override
    public PageResult<InvoicingAvailableResultVo> invoicingAvailable(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.invoicingAvailable(pageReqVO);
        final List<InvoicingAvailableResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            InvoicingAvailableResultVo vo = new InvoicingAvailableResultVo();
//          invoicingAvailable = recordIncomeNoTax - totalInvoicedNoTax
            vo.setInvoicingAvailable(item.getRecordIncomeNoTax().subtract(item.getTotalInvoicedNoTax()));
            BeanUtil.copyProperties(item, vo);
            return vo;
        }).toList();
        PageResult<InvoicingAvailableResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }

    /**
     * 8 零进取
     */
    @Override
    public PageResult<ZeroIncomeResultVo> zeroIncome(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.zeroIncome(pageReqVO);
        final List<ZeroIncomeResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            ZeroIncomeResultVo vo = new ZeroIncomeResultVo();
            BeanUtil.copyProperties(item, vo);
//          zeroIncome = plannedIncomeNoTax - recordIncomeNoTax
            vo.setZeroIncome(item.getPlannedIncomeNoTax().subtract(item.getRecordIncomeNoTax()));
//          other = laborCost - actualLaborCost
            vo.setOther(item.getLaborCost().subtract(item.getActualLaborCost()));
            return vo;
        }).toList();
        PageResult<ZeroIncomeResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }

    /**
     * 9可分包
     */
    @Override
    public PageResult<SubcontractableResultVo> subcontractable(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.subcontractable(pageReqVO);
        final List<SubcontractableResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            SubcontractableResultVo vo = new SubcontractableResultVo();
            BeanUtil.copyProperties(item, vo);
//          subcontractable = outsourcingCost - actualOutsourcingCost
            vo.setSubcontractable(item.getOutsourcingCost().subtract(item.getActualOutsourcingCost()));
            return vo;
        }).toList();
        PageResult<SubcontractableResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }


    /**
     * 10可用人工
     */
    @Override
    public PageResult<ManpowerAvailableResultVo> manpowerAvailable(TongFuProjectQueryVO pageReqVO) {
        PageResult<TongFuProjectDO> payablePage = tongFuProjectMapper.manpowerAvailable(pageReqVO);
        final List<ManpowerAvailableResultVo> queryVOS = payablePage.getList().stream().map(item -> {
            ManpowerAvailableResultVo vo = new ManpowerAvailableResultVo();
            BeanUtil.copyProperties(item, vo);
            return vo;
        }).toList();
        PageResult<ManpowerAvailableResultVo> pageResult=new PageResult<>();
        pageResult.setTotal(payablePage.getTotal());
        pageResult.setList(queryVOS);
        return pageResult;
    }

    /**
     * 12 可用其他费
     */
    @Override
    public PageResult<AvailableOtherExpensesResultVo> availableOtherExpenses(TongFuProjectQueryVO pageReqVO) {

        return null;
    }

    /**
     * 13 可用材料费
     */
    @Override
    public PageResult<AvailableMaterialCostsResultVo> availableMaterialCosts(TongFuProjectQueryVO pageReqVO) {


        return null;
    }

    /**
     * 14 回款差异
     */
    @Override
    public PageResult<PaymentCollectionVarianceResultVo> paymentCollectionVariance(TongFuProjectQueryVO pageReqVO) {
        return null;
    }


    /**
     * 15 计划收入大
     */
    @Override
    public PageResult<HighPlannedRevenueResultVo> highPlannedRevenue(TongFuProjectQueryVO pageReqVO) {

        return null;
    }


    /**
     * 16 可关闭
     */
    @Override
    public PageResult<ClosableResultVo> closable(TongFuProjectQueryVO pageReqVO) {

        return null;
    }

    /**
     * 17 计划收入小
     */
    @Override
    public PageResult<LowPlannedRevenueResultVo> lowPlannedRevenue(TongFuProjectQueryVO pageReqVO) {


        return null;
    }


}
