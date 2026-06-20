package com.store.ccsc.module.system.controller.admin.investmentmanagement.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.store.ccsc.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static com.store.ccsc.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 工程投资管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class InvestmentManagementPageReqVO extends PageParam {

    @Schema(description = "工程编号", example = "15SN005366001")
    private String engineeringNo;

    @Schema(description = "工程名称", example = "王五")
    private String engineeringName;

    @Schema(description = "施工单位", example = "赵六")
    private String constructionCompany;

    @Schema(description = "工程状态", example = "一阶段设计已批复")
    private String engineeringStatus;

    @Schema(description = "工程管理员", example = "王高鹏")
    private String engineeringManager;

    @Schema(description = "一级专业", example = "无线网")
    private String firstLevelMajor;

    @Schema(description = "审计状态(0:待审计,1:已审计)")
    private String auditStatus;



}