package com.store.ccsc.module.system.controller.admin.incomeStatement.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 收入清单新增/修改 Request VO")
@Data
public class IncomeStatementSaveReqVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "11169")
    private Long id;

    @Schema(description = "专业")
    private String major;

    /**
     * 工程编号
     */
    private String engineeringNo;
    /**
     * 工程名称
     */
    private String engineeringName;
    /**
     * 工程管理员
     */
    private String engineeringManager;
    /**
     * 施工单位
     */
    private String constructionCompany;

    @Schema(description = "通服项目编号")
    private String tfsProjectCode;

    @Schema(description = "项目编码核对")
    private String projectCodeChecking;

    @Schema(description = "项目", example = "李四")
    private String projectName;

    @Schema(description = "项目经理")
    private String projectManager;

    @Schema(description = "工队")
    private String workTeam;

    @Schema(description = "农民工")
    private String migrantWorker;

    @Schema(description = "电信应付款")
    private BigDecimal telecomPayable;

    @Schema(description = "电信付款", example = "15974")
    private BigDecimal telecomPaid;

    @Schema(description = "付款月份")
    private String payMonth;

    @Schema(description = "通服应收款")
    private BigDecimal tfsReceivable;

    @Schema(description = "通服已收款")
    private BigDecimal tfsReceived;

    @Schema(description = "通服应收款-已收款")
    private BigDecimal tfsDiff;

    @Schema(description = "应收账款")
    private BigDecimal receivable;

    @Schema(description = "送审金额")
    private BigDecimal submitAmount;

    @Schema(description = "审定金额")
    private BigDecimal checkedAmount;

    @Schema(description = "安全生产费")
    private BigDecimal safetyFee;

    @Schema(description = "乙供材报审")
    private BigDecimal supplierMaterialSubmit;

    @Schema(description = "乙供材")
    private BigDecimal supplierMaterial;

    @Schema(description = "赔补费")
    private BigDecimal compensationFee;

    @Schema(description = "协调费搬运费")
    private BigDecimal coordinationFee;

    @Schema(description = "分包比例")
    private BigDecimal subcontractRatio;

    @Schema(description = "项目收入")
    private BigDecimal projectIncome;

    @Schema(description = "劳务工价", example = "14453")
    private BigDecimal laborPrice;

    @Schema(description = "送审技工")
    private BigDecimal submitSkilledWorker;

    @Schema(description = "送审普工")
    private BigDecimal submitGeneralWorker;

    @Schema(description = "审定技工")
    private BigDecimal checkedSkilledWorker;

    @Schema(description = "审定普工")
    private BigDecimal checkedGeneralWorker;

    @Schema(description = "施工费")
    private BigDecimal constructionFee;

    @Schema(description = "立项金额（含税）")
    private BigDecimal projectApprovedAmountTax;

    @Schema(description = "立项金额（不含税）")
    private BigDecimal projectApprovedAmount;

    @Schema(description = "利润")
    private BigDecimal profit;

    @Schema(description = "立项成本")
    private BigDecimal projectCost;

    @Schema(description = "人工")
    private BigDecimal laborCost;

    @Schema(description = "分包费（含税）")
    private BigDecimal subcontractFeeTax;

    @Schema(description = "外包人员工资")
    private BigDecimal outsourceSalary;

    @Schema(description = "现场费")
    private BigDecimal siteFee;

    @Schema(description = "可用其他成本")
    private BigDecimal otherCost;

    @Schema(description = "毛利率")
    private BigDecimal grossProfitRate;

    @Schema(description = "利润率")
    private BigDecimal profitRate;

    @Schema(description = "人工占比")
    private BigDecimal laborRatio;

    @Schema(description = "现场费占比")
    private BigDecimal siteFeeRatio;

    @Schema(description = "外包费")
    private BigDecimal outsourceFee;

    @Schema(description = "综合工日单价", example = "12979")
    private BigDecimal comprehensiveWorkDayPrice;

    @Schema(description = "电信欠款")
    private BigDecimal telecomArrears;


}