package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/14/014 16:51
 * @Description: 可分包
 */
@Data
public class SubcontractableResultVo {


    private Long id;

    @ExcelProperty("项目编号")
    private String tfsProjectCode;

    @ExcelProperty("项目名称")
    private String engineeringName;

    @ExcelProperty("计划收入(含税)")
    private BigDecimal plannedIncomeTax;

    @ExcelProperty("计划收入(不含税)")
    private BigDecimal plannedIncomeNoTax;

    @ExcelProperty("列账收入(含税)")
    private BigDecimal recordIncomeTax;

    @ExcelProperty("列账收入(未税)")
    private BigDecimal recordIncomeNoTax;

    @ExcelProperty("累计收款(含税)")
    private BigDecimal totalReceivedTax;

    @ExcelProperty("外包/合作费成本")
    private BigDecimal outsourcingCost;

    @ExcelProperty("实际外包成本")
    private BigDecimal actualOutsourcingCost;

    @ExcelProperty("累计收票(含税)")
    private BigDecimal totalInvoiceReceivedTax;

    // subcontractable = outsourcingCost - actualOutsourcingCost
    @ExcelProperty("可分包")
    private BigDecimal subcontractable;



}
