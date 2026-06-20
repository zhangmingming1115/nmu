package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/13/013 16:23
 * @Description: 可直接付款 查询返回vo
 */
@Data
@ExcelIgnoreUnannotated
public class DirectPayableResultVo{

    private Long id;

    @ExcelProperty("项目编号")
    private String tfsProjectCode;

    @ExcelProperty("项目名称")
    private String engineeringName;

    @ExcelProperty("客户名称")
    private String customerName;

    @ExcelProperty("累计付款(含税)")
    private BigDecimal totalPaidTax;

    @ExcelProperty("累计收款(含税)")
    private BigDecimal totalReceivedTax;

    @ExcelProperty("累计开票(含税)")
    private BigDecimal totalInvoicedTax;

    @ExcelProperty("累计收票(含税)")
    private BigDecimal totalInvoiceReceivedTax;
    /**
     * 可直接付款 = 累计收票(含税)-累计付款(含税)
     * directPayable = totalInvoiceReceivedTax-totalPaidTax
     */
    @ExcelProperty("可直接付款")
    private BigDecimal  directPayable;

}
