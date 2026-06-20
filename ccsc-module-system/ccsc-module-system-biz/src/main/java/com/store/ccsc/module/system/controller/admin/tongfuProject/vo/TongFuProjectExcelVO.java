package com.store.ccsc.module.system.controller.admin.tongfuProject.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false) // 设置 chain = false，避免用户导入有问题
public class TongFuProjectExcelVO {


    @ExcelProperty("项目编号")
    private String tfsProjectCode;

    @ExcelProperty("项目名称")
    private String engineeringName;

    @ExcelProperty("甲方项目编号")
    private String engineeringNo;

    @ExcelProperty("客户名称")
    private String customerName;


    @ExcelProperty("项目经理名称")
    private String projectManager;

    @ExcelProperty("经办人")
    private String operator;

    @ExcelProperty("计划收入(含税)")
    private BigDecimal plannedIncomeTax;

    @ExcelProperty("计划收入(不含税)")
    private BigDecimal plannedIncomeNoTax;

    @ExcelProperty("累计开票(含税)")
    private BigDecimal totalInvoicedTax;

    @ExcelProperty("累计开票(不含税)")
    private BigDecimal totalInvoicedNoTax;

    @ExcelProperty("项目收入合同金额(不含税)")
    private BigDecimal contractIncomeNoTax;

    @ExcelProperty("列账收入(含税)")
    private BigDecimal recordIncomeTax;

    @ExcelProperty("列账收入(未税)")
    private BigDecimal recordIncomeNoTax;

    @ExcelProperty("累计收款(含税)")
    private BigDecimal totalReceivedTax;

    @ExcelProperty("审定金额（不含税）")
    private BigDecimal checkedAmountNoTax;

    @ExcelProperty("计划成本")
    private BigDecimal plannedCost;

    @ExcelProperty("材料费成本")
    private BigDecimal materialCost;

    @ExcelProperty("外包/合作费成本")
    private BigDecimal outsourcingCost;

    @ExcelProperty("其他费成本")
    private BigDecimal otherCost;

    @ExcelProperty("人工成本")
    private BigDecimal laborCost;

    @ExcelProperty("累计收票(含税)")
    private BigDecimal totalInvoiceReceivedTax;

    @ExcelProperty("实际成本")
    private BigDecimal actualCost;

    @ExcelProperty("实际人工成本")
    private BigDecimal actualLaborCost;

    @ExcelProperty("实际材料成本")
    private BigDecimal actualMaterialCost;

    @ExcelProperty("实际外包成本")
    private BigDecimal actualOutsourcingCost;

    @ExcelProperty("实际其他成本")
    private BigDecimal actualOtherCost;

    @ExcelProperty("累计付款(含税)")
    private BigDecimal totalPaidTax;

    @ExcelProperty("计划毛利率%")
    private BigDecimal plannedGrossProfitRate;

    @ExcelProperty("实际毛利率%")
    private BigDecimal actualGrossProfitRate;




    @ExcelProperty("负责部门编号")
    private String responsibleDepartment;

    @ExcelProperty("专业类型名称")
    private String professionalTypeName;

    @ExcelProperty("所属公司")  // 陕西省通信服务有限公司商洛分公司
    private String affiliatedCompany;

    @ExcelProperty("项目结项状态")
    private String projectClosureStatus;


}