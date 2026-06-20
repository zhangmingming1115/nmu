package com.store.ccsc.module.system.controller.admin.tongfuProject.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 工程投资管理 Excel 导入 VO
 */

@Schema(description = "管理后台 - 通服工程导入 Response VO")
@Data
@Builder
public class TongFuProjectImportRespVO {

    @Schema(description = "创建成功的工程数组", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createNames;

    @Schema(description = "更新成功的工程名数组", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateNames;

    @Schema(description = "导入失败的工程集合，key 为 工程编号(engineeringNo)，value 为 失败原因", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureNames;

}