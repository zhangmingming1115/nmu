package com.store.ccsc.module.system.controller.admin.incomeStatement.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.store.ccsc.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static com.store.ccsc.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 收入清单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IncomeStatementPageReqVO extends PageParam {

    @Schema(description = "工程编码")
    private String engineeringNo;

    @Schema(description = "通服项目编号")
    private String tfsProjectCode;

    @Schema(description = "项目经理")
    private String projectManager;

}