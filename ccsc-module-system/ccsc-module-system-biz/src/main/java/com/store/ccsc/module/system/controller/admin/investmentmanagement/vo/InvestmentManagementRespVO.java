package com.store.ccsc.module.system.controller.admin.investmentmanagement.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 工程投资管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class InvestmentManagementRespVO {

    @Schema(description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "21849")
    @ExcelProperty("主键ID")
    private Long id;

    @Schema(description = "序号")
    @ExcelProperty("序号")
    private Integer serialNumber;

    @Schema(description = "投资渠道")
    @ExcelProperty("投资渠道")
    private String investmentChannel;

    @Schema(description = "项目编号")
    @ExcelProperty("项目编号")
    private String projectNo;

    @Schema(description = "项目名称", example = "王五")
    @ExcelProperty("项目名称")
    private String projectName;

    @Schema(description = "工程编号")
    @ExcelProperty("工程编号")
    private String engineeringNo;

    @Schema(description = "工程名称", example = "赵六")
    @ExcelProperty("工程名称")
    private String engineeringName;

    @Schema(description = "建设单位")
    @ExcelProperty("建设单位")
    private String constructionUnit;

    @Schema(description = "工程状态", example = "2")
    @ExcelProperty("工程状态")
    private String engineeringStatus;

    @Schema(description = "工程管理员")
    @ExcelProperty("工程管理员")
    private String engineeringManager;

    @Schema(description = "一级专业")
    @ExcelProperty("一级专业")
    private String firstLevelMajor;

    @Schema(description = "二级专业")
    @ExcelProperty("二级专业")
    private String secondLevelMajor;

    @Schema(description = "专业标签")
    @ExcelProperty("专业标签")
    private String majorTag;

    @Schema(description = "立项批复日期")
    @ExcelProperty("立项批复日期")
    private LocalDateTime approvalDateOfProjectInitiation;

    @Schema(description = "实际开工日期")
    @ExcelProperty("实际开工日期")
    private LocalDateTime actualStartDate;

    @Schema(description = "实际初验日期")
    @ExcelProperty("实际初验日期")
    private LocalDateTime actualPreliminaryAcceptanceDate;

    @Schema(description = "提交预转固日期")
    @ExcelProperty("提交预转固日期")
    private LocalDateTime dateOfPreFixedAssetApplication;

    @Schema(description = "预转固日期")
    @ExcelProperty("预转固日期")
    private LocalDateTime preFixedAssetDate;

    @Schema(description = "实际终验日期")
    @ExcelProperty("实际终验日期")
    private LocalDateTime actualFinalAcceptanceDate;

    @Schema(description = "提交决算／转固日期")
    @ExcelProperty("提交决算／转固日期")
    private LocalDateTime dateOfFinalAccountFixedAssetTransfer;

    @Schema(description = "转固日期")
    @ExcelProperty("转固日期")
    private LocalDateTime fixedAssetTransferDate;

    @Schema(description = "工程总投资(元)")
    @ExcelProperty("工程总投资(元)")
    private BigDecimal totalProjectInvestment;

    @Schema(description = "施工单位")
    @ExcelProperty("施工单位")
    private String constructionCompany;

    @Schema(description = "施工金额(含增值税)(元)")
    @ExcelProperty("施工金额(含增值税)(元)")
    private BigDecimal constructionAmountIncludingVat;

    @Schema(description = "设计单位")
    @ExcelProperty("设计单位")
    private String designCompany;

    @Schema(description = "设计金额(含增值税)(元)")
    @ExcelProperty("设计金额(含增值税)(元)")
    private BigDecimal designAmountIncludingVat;

    @Schema(description = "监理单位")
    @ExcelProperty("监理单位")
    private String supervisionCompany;

    @Schema(description = "监理金额(含增值税)(元)")
    @ExcelProperty("监理金额(含增值税)(元)")
    private BigDecimal supervisionAmountIncludingVat;

    @Schema(description = "累计完成投资(元)")
    @ExcelProperty("累计完成投资(元)")
    private BigDecimal cumulativeCompletedInvestment;

    @Schema(description = "本年完成投资(元)")
    @ExcelProperty("本年完成投资(元)")
    private BigDecimal currentYearCompletedInvestment;

    @Schema(description = "本年投资(元)")
    @ExcelProperty("本年投资(元)")
    private BigDecimal currentYearInvestment;

    @Schema(description = "工程关闭日期")
    @ExcelProperty("工程关闭日期")
    private LocalDateTime projectCloseDate;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}