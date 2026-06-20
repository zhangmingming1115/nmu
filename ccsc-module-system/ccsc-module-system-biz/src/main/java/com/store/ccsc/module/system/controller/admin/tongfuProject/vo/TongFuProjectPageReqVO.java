package com.store.ccsc.module.system.controller.admin.tongfuProject.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.store.ccsc.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static com.store.ccsc.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 通服项目分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TongFuProjectPageReqVO extends PageParam {

    @Schema(description = "通服项目编号")
    private String tfsProjectCode;

    @Schema(description = "客户名称", example = "张三")
    private String customerName;

    @Schema(description = "甲方项目编号(工程编号)")
    private String engineeringNo;

    @Schema(description = "项目经理名称")
    private String projectManager;

    @Schema(description = "经办人")
    private String operator;

}