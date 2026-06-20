package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/13/013 16:23
 * @Description: 可收票 查询返回vo
 */
@Data
public class AcceptableInvoicingResultVo {

    private Long id;

    @ExcelProperty("项目编号")
    private String tfsProjectCode;

    @ExcelProperty("项目名称")
    private String engineeringName;

    @ExcelProperty("客户名称")
    private String customerName;

    @ExcelProperty("列账收入(含税)")
    private BigDecimal recordIncomeTax;

    @ExcelProperty("列账收入(未税)")
    private BigDecimal recordIncomeNoTax;

    @ExcelProperty("累计收款(含税)")
    private BigDecimal totalReceivedTax;

    @ExcelProperty("累计收票(含税)")
    private BigDecimal totalInvoiceReceivedTax;

    @ExcelProperty("累计付款(含税)")
    private BigDecimal totalPaidTax;

    /**
     * 可收票 = 外包成本  - 实际外包成本
     * outsourcingCost - actualOutsourcingCost
     */
    private BigDecimal  acceptableInvoicing;


}
