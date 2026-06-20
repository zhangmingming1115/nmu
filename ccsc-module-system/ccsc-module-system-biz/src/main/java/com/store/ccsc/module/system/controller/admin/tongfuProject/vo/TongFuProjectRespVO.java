package com.store.ccsc.module.system.controller.admin.tongfuProject.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 通服项目 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TongFuProjectRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19424")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "通服项目编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("通服项目编号")
    private String tfsProjectCode;

    @Schema(description = "客户名称", example = "张三")
    @ExcelProperty("客户名称")
    private String customerName;

    @Schema(description = "甲方项目编号(工程编号)")
    private String engineeringNo;

    @Schema(description = "项目经理名称")
    @ExcelProperty("项目经理名称")
    private String projectManager;

    @Schema(description = "经办人")
    @ExcelProperty("经办人")
    private String operator;

    @Schema(description = "计划收入(含税)")
    @ExcelProperty("计划收入(含税)")
    private BigDecimal plannedIncomeTax;

    @Schema(description = "计划收入(不含税)")
    @ExcelProperty("计划收入(不含税)")
    private BigDecimal plannedIncomeNoTax;

    @Schema(description = "累计开票(含税)")
    @ExcelProperty("累计开票(含税)")
    private BigDecimal totalInvoicedTax;

    @Schema(description = "累计开票(不含税)")
    @ExcelProperty("累计开票(不含税)")
    private BigDecimal totalInvoicedNoTax;

    @Schema(description = "项目收入合同金额(不含税)")
    @ExcelProperty("项目收入合同金额(不含税)")
    private BigDecimal contractIncomeNoTax;

    @Schema(description = "列账收入(含税)")
    @ExcelProperty("列账收入(含税)")
    private BigDecimal recordIncomeTax;

    @Schema(description = "列账收入(未税)")
    @ExcelProperty("列账收入(未税)")
    private BigDecimal recordIncomeNoTax;

    @Schema(description = "累计收款(含税)")
    @ExcelProperty("累计收款(含税)")
    private BigDecimal totalReceivedTax;

    @Schema(description = "审定金额（不含税）")
    @ExcelProperty("审定金额（不含税）")
    private BigDecimal checkedAmountNoTax;

    @Schema(description = "计划成本")
    @ExcelProperty("计划成本")
    private BigDecimal plannedCost;

    @Schema(description = "材料费成本")
    @ExcelProperty("材料费成本")
    private BigDecimal materialCost;

    @Schema(description = "外包成本")
    @ExcelProperty("外包成本")
    private BigDecimal outsourcingCost;

    @Schema(description = "其他费成本")
    @ExcelProperty("其他费成本")
    private BigDecimal otherCost;

    @Schema(description = "人工成本")
    private BigDecimal laborCost;

    @Schema(description = "累计收票(含税)")
    @ExcelProperty("累计收票(含税)")
    private BigDecimal totalInvoiceReceivedTax;

    @Schema(description = "实际成本")
    @ExcelProperty("实际成本")
    private BigDecimal actualCost;

    @Schema(description = "实际人工成本")
    @ExcelProperty("实际人工成本")
    private BigDecimal actualLaborCost;

    @Schema(description = "实际材料成本")
    @ExcelProperty("实际材料成本")
    private BigDecimal actualMaterialCost;

    @Schema(description = "实际外包成本")
    @ExcelProperty("实际外包成本")
    private BigDecimal actualOutsourcingCost;

    @Schema(description = "实际其他成本")
    @ExcelProperty("实际其他成本")
    private BigDecimal actualOtherCost;

    @Schema(description = "累计付款(含税)")
    @ExcelProperty("累计付款(含税)")
    private BigDecimal totalPaidTax;

    @Schema(description = "计划毛利率%")
    @ExcelProperty("计划毛利率%")
    private BigDecimal plannedGrossProfitRate;

    @Schema(description = "实际毛利率%")
    @ExcelProperty("实际毛利率%")
    private BigDecimal actualGrossProfitRate;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;



    @ExcelProperty("负责部门编号")   // 6100240004
    private String responsibleDepartment;

    @ExcelProperty("专业类型名称")  //  专业类型名称  professional_type_name  工程施工-管线工程-通信线路施工-线路
    private String professionalTypeName;

    @ExcelProperty("所属公司")  // 陕西省通信服务有限公司商洛分公司
    private String affiliatedCompany;

    @ExcelProperty("项目结项状态")         // 立项已完成
    private String projectClosureStatus;


    // 以下是收入清单信息
    @Schema(description = "工程名称")
    private String engineeringName;
    @Schema(description = "送审金额")
    private BigDecimal submitAmount;
    @Schema(description = "乙供材报审")
    private BigDecimal supplierMaterialSubmit;
    @Schema(description = "送审技工")
    private BigDecimal submitSkilledWorker;
    @Schema(description = "送审普工")
    private BigDecimal submitGeneralWorker;
    @Schema(description = "审定金额")
    private BigDecimal checkedAmount;
    @Schema(description = "乙供材")
    private BigDecimal supplierMaterial;
    @Schema(description = "审定技工")
    private BigDecimal checkedSkilledWorker;
    @Schema(description = "审定普工")
    private BigDecimal checkedGeneralWorker;
    @Schema(description = "安全生产费")
    private BigDecimal safetyFee;
    @Schema(description = "赔补费")
    private BigDecimal compensationFee;
    @Schema(description = "协调费搬运费")
    private BigDecimal coordinationFee;

}