package com.store.ccsc.module.system.controller.admin.investmentmanagement;

import com.store.ccsc.framework.common.pojo.CommonResult;
import com.store.ccsc.framework.common.pojo.PageParam;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.common.util.object.BeanUtils;
import com.store.ccsc.framework.excel.core.util.ExcelUtils;
import com.store.ccsc.framework.operatelog.core.annotations.OperateLog;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.*;
import com.store.ccsc.module.system.dal.dataobject.investmentmanagement.InvestmentManagementDO;
import com.store.ccsc.module.system.service.investmentmanagement.InvestmentManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.store.ccsc.framework.common.pojo.CommonResult.success;
import static com.store.ccsc.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "管理后台 - 工程投资管理")
@RestController
@RequestMapping("/engineering/investment-management")
@Validated
public class InvestmentManagementController {

    @Resource
    private InvestmentManagementService investmentManagementService;

    @PostMapping("/create")
    @Operation(summary = "创建工程投资管理")
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:create')")
    public CommonResult<Long> createInvestmentManagement(@Valid @RequestBody InvestmentManagementSaveReqVO createReqVO) {
        return success(investmentManagementService.createInvestmentManagement(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新工程投资管理")
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:update')")
    public CommonResult<Boolean> updateInvestmentManagement(@Valid @RequestBody InvestmentManagementSaveReqVO updateReqVO) {
        investmentManagementService.updateInvestmentManagement(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除工程投资管理")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:delete')")
    public CommonResult<Boolean> deleteInvestmentManagement(@RequestParam("id") Long id) {
        investmentManagementService.deleteInvestmentManagement(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得工程投资管理")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:query')")
    public CommonResult<InvestmentManagementRespVO> getInvestmentManagement(@RequestParam("id") Long id) {
        InvestmentManagementDO investmentManagement = investmentManagementService.getInvestmentManagement(id);
        return success(BeanUtils.toBean(investmentManagement, InvestmentManagementRespVO.class));
    }


    @GetMapping("/getByEngineeringNo")
    @Operation(summary = "获得工程投资管理")
    @Parameter(name = "engineeringNo", description = "工程编号", required = true, example = "25SN004006001")
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:query')")
    public CommonResult<InvestmentManagementRespVO> getByEngineeringNo(@RequestParam("engineeringNo") String engineeringNo) {
        InvestmentManagementDO investmentManagement = investmentManagementService.getByEngineeringNo(engineeringNo);
        return success(BeanUtils.toBean(investmentManagement, InvestmentManagementRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得工程投资管理分页")
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:query')")
    public CommonResult<PageResult<InvestmentManagementRespVO>> getInvestmentManagementPage(@Valid InvestmentManagementPageReqVO pageReqVO) {
        PageResult<InvestmentManagementDO> pageResult = investmentManagementService.getInvestmentManagementPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, InvestmentManagementRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出工程投资管理 Excel")
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:export')")
    @OperateLog(type = EXPORT)
    public void exportInvestmentManagementExcel(@Valid InvestmentManagementPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<InvestmentManagementDO> list = investmentManagementService.getInvestmentManagementPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "工程投资管理.xls", "数据", InvestmentManagementRespVO.class,
                        BeanUtils.toBean(list, InvestmentManagementRespVO.class));
    }

    @GetMapping("/get-import-template")
    @Operation(summary = "获得工程投资管理模板")
    public void importTemplate(HttpServletResponse response) throws IOException {
        List<InvestmentManagementExcelVO> list = Arrays.asList(InvestmentManagementExcelVO.getExportData());
        // 输出
        ExcelUtils.write(response, "工程投资管理导入模板.xls", "工程投资管理列表", InvestmentManagementExcelVO.class, list);
    }

    @PostMapping("/import")
    @Operation(summary = "导入工程投资管理数据")
    @Parameters({
            @Parameter(name = "file", description = "Excel 文件", required = true),
            @Parameter(name = "updateSupport", description = "是否支持更新，默认为 false", example = "true")
    })
    @PreAuthorize("@ss.hasPermission('engineering:investment-management:import')")
    public CommonResult<InvestmentManagementImportRespVO> importExcel(@RequestParam("file") MultipartFile file,
                                                                      @RequestParam(value = "updateSupport", required = false, defaultValue = "false") Boolean updateSupport) throws Exception {
        List<InvestmentManagementExcelVO> list = null;
        try {
            list = ExcelUtils.read(file, InvestmentManagementExcelVO.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return success(investmentManagementService.importInvestmentManagementList(list, updateSupport));
    }


    @GetMapping("/getBatchNumberList")
    @Operation(summary = "获得批次号列表")
    public CommonResult<List<String>> getBatchNumberList() {
        List<String> batchNumberList = investmentManagementService.getBatchNumberList();
        return success(batchNumberList);
    }

    @GetMapping("/getEngineeringStatusList")
    @Operation(summary = "返回工程状态下拉框")
    public CommonResult<List<String>> getEngineeringStatusList() {
        List<String> engineeringStatusList = investmentManagementService.getEngineeringStatusList();
        return success(engineeringStatusList);
    }

    @GetMapping("/getFirstLevelMajorList")
    @Operation(summary = "返回一级专业下拉框")
    public CommonResult<List<String>> getFirstLevelMajorList() {
        List<String> firstLevelMajorList = investmentManagementService.getFirstLevelMajorList();
        return success(firstLevelMajorList);
    }

    @Operation(summary = "返回施工单位下拉框")
    @GetMapping("/getConstructionCompanyList")
    public CommonResult<List<String>> getConstructionCompanyList() {
        List<String> companyList = investmentManagementService.getConstructionCompanyList();
        return success(companyList);
    }



}