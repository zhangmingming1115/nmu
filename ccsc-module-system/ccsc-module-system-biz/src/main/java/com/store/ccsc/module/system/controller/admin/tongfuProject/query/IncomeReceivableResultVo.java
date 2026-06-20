package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/14/014 16:43
 * @Description: 5可进取
 */
@Data
public class IncomeReceivableResultVo {

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

    @ExcelProperty("累计开票(含税)")
    private BigDecimal totalInvoicedTax;

    @ExcelProperty("累计收款(含税)")
    private BigDecimal totalReceivedTax;

    // incomeReceivable = totalInvoicedNoTax - recordIncomeNoTax
    @ExcelProperty("可进取(不含税)")
    private BigDecimal incomeReceivable;



}
