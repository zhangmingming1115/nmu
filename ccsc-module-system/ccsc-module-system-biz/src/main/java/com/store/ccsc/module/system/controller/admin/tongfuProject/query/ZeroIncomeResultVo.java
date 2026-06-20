package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/14/014 16:49
 * @Description: 8  0进取
 */
@Data
public class ZeroIncomeResultVo {


    private Long id;

    @ExcelProperty("项目编号")
    private String tfsProjectCode;

    @ExcelProperty("项目名称")
    private String engineeringName;

    @ExcelProperty("客户名称")
    private String customerName;

    @ExcelProperty("计划收入(不含税)")
    private BigDecimal plannedIncomeNoTax;

    @ExcelProperty("列账收入(未税)")
    private BigDecimal recordIncomeNoTax;

    @ExcelProperty("累计开票(不含税)")
    private BigDecimal totalInvoicedNoTax;

    @ExcelProperty("累计收款(含税)")
    private BigDecimal totalReceivedTax;

    // zeroIncome = plannedIncomeNoTax - recordIncomeNoTax
    @ExcelProperty("可进取")
    private BigDecimal zeroIncome;

    @ExcelProperty("计划毛利率%")
    private BigDecimal plannedGrossProfitRate;

    // other = laborCost - actualLaborCost
    @ExcelProperty("其他")
    private BigDecimal other;


}
