package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/14/014 16:47
 * @Description: 7可开票
 */
@Data
public class InvoicingAvailableResultVo {


    private Long id;

    @ExcelProperty("项目编号")
    private String tfsProjectCode;

    @ExcelProperty("项目名称")
    private String engineeringName;

    @ExcelProperty("客户名称")
    private String customerName;

    @ExcelProperty("列账收入(未税)")
    private BigDecimal recordIncomeNoTax;

    @ExcelProperty("累计开票(不含税)")
    private BigDecimal totalInvoicedNoTax;

    // invoicingAvailable = recordIncomeNoTax - totalInvoicedNoTax
    @ExcelProperty("可开票不含税")
    private BigDecimal invoicingAvailable;



}
