package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/13/013 16:23
 * @Description: 10 可用人工 查询返回vo
 */
@Data
public class ManpowerAvailableResultVo {

    private Long id;

    @ExcelProperty("项目编号")
    private String tfsProjectCode;

    @ExcelProperty("项目名称")
    private String engineeringName;

    @ExcelProperty("外包成本")
    private String outsourcingCost;

    @ExcelProperty("累计收票(含税)")
    private BigDecimal totalInvoiceReceivedTax;

    @ExcelProperty("实际成本")
    private BigDecimal actualCost;

    @ExcelProperty("实际材料成本")
    private BigDecimal actualMaterialCost;

    @ExcelProperty("项目收入合同金额(不含税)")
    private BigDecimal contractIncomeNoTax;





}
