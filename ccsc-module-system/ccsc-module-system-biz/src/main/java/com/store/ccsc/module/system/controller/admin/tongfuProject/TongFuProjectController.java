package com.store.ccsc.module.system.controller.admin.tongfuProject;

import cn.hutool.core.bean.BeanUtil;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementExcelVO;
import com.store.ccsc.module.system.controller.admin.tongfuProject.vo.*;
import com.store.ccsc.module.system.dal.dataobject.incomeStatement.IncomeStatementDO;
import com.store.ccsc.module.system.dal.dataobject.tongfuProject.TongFuProjectDO;
import com.store.ccsc.module.system.service.tongfuProject.TongFuProjectService;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.store.ccsc.framework.common.pojo.PageParam;
import com.store.ccsc.framework.common.pojo.CommonResult;
import com.store.ccsc.framework.common.util.object.BeanUtils;
import static com.store.ccsc.framework.common.pojo.CommonResult.success;

import com.store.ccsc.framework.excel.core.util.ExcelUtils;

import com.store.ccsc.framework.operatelog.core.annotations.OperateLog;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.store.ccsc.framework.operatelog.core.enums.OperateTypeEnum.*;


@Tag(name = "管理后台 - 通服项目")
@RestController
@RequestMapping("/tongfu/tong-fu-project")
@Validated
public class TongFuProjectController {

    @Resource
    private TongFuProjectService tongFuProjectService;

    @PostMapping("/create")
    @Operation(summary = "创建通服项目")
    @PreAuthorize("@ss.hasPermission('tongfu:tong-fu-project:create')")
    public CommonResult<Long> createTongFuProject(@Valid @RequestBody TongFuProjectSaveReqVO createReqVO) {
        return success(tongFuProjectService.createTongFuProject(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新通服项目")
    @PreAuthorize("@ss.hasPermission('tongfu:tong-fu-project:update')")
    public CommonResult<Boolean> updateTongFuProject(@Valid @RequestBody TongFuProjectSaveReqVO updateReqVO) {
        tongFuProjectService.updateTongFuProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除通服项目")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('tongfu:tong-fu-project:delete')")
    public CommonResult<Boolean> deleteTongFuProject(@RequestParam("id") Long id) {
        tongFuProjectService.deleteTongFuProject(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得通服项目")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('tongfu:tong-fu-project:query')")
    public CommonResult<TongFuProjectRespVO> getTongFuProject(@RequestParam("id") Long id) {
        TongFuProjectDO tongFuProject = tongFuProjectService.getTongFuProject(id);
        TongFuProjectRespVO respVO = BeanUtils.toBean(tongFuProject, TongFuProjectRespVO.class);
        IncomeStatementDO incomeStatement = tongFuProjectService.getIncomeStatementData(id);
        BeanUtil.copyProperties(incomeStatement,respVO);
        respVO.setId(tongFuProject.getId());
        return success(respVO);
    }

    @GetMapping("/page")
    @Operation(summary = "获得通服项目分页")
    @PreAuthorize("@ss.hasPermission('tongfu:tong-fu-project:query')")
    public CommonResult<PageResult<TongFuProjectRespVO>> getTongFuProjectPage(@Valid TongFuProjectPageReqVO pageReqVO) {
        PageResult<TongFuProjectDO> pageResult = tongFuProjectService.getTongFuProjectPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TongFuProjectRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出通服项目 Excel")
    @PreAuthorize("@ss.hasPermission('tongfu:tong-fu-project:export')")
    @OperateLog(type = EXPORT)
    public void exportTongFuProjectExcel(@Valid TongFuProjectPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TongFuProjectDO> list = tongFuProjectService.getTongFuProjectPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "通服项目.xls", "数据", TongFuProjectRespVO.class,
                        BeanUtils.toBean(list, TongFuProjectRespVO.class));
    }

    @GetMapping("/getIncomeStatementData")
    @Operation(summary = "获得收入情况")
    @Parameter(name = "tongFuProjectId", description = "通服项目id", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('tongfu:tong-fu-project:query')")
    public CommonResult<IncomeStatementDO> getIncomeStatementData(@RequestParam("tongFuProjectId") Long tongFuProjectId) {
        IncomeStatementDO incomeStatement = tongFuProjectService.getIncomeStatementData(tongFuProjectId);
        return success(BeanUtils.toBean(incomeStatement, IncomeStatementDO.class));
    }


    @GetMapping("/get-import-template")
    @Operation(summary = "获得通服项目管理模板")
    public void importTemplate(HttpServletResponse response) throws IOException {
        List<InvestmentManagementExcelVO> list = Arrays.asList(InvestmentManagementExcelVO.getExportData());
        // 输出
        ExcelUtils.write(response, "通服项目导入模板.xls", "通服项目列表", InvestmentManagementExcelVO.class, list);
    }

    @PostMapping("/import")
    @Operation(summary = "下载 通服项目Excel导入模板")
    @Parameters({
            @Parameter(name = "file", description = "Excel 文件", required = true),
            @Parameter(name = "updateSupport", description = "是否支持更新，默认为 false", example = "true")
    })
    @PreAuthorize("@ss.hasPermission('engineering:tong-fu-project:import')")
    public CommonResult<TongFuProjectImportRespVO> importExcel(@RequestParam("file") MultipartFile file,
                                                               @RequestParam(value = "updateSupport", required = false, defaultValue = "false") Boolean updateSupport) throws Exception {
        List<TongFuProjectExcelVO> list = null;
        try {
            list = ExcelUtils.read(file, TongFuProjectExcelVO.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return success(tongFuProjectService.importTongFuProjectList(list, updateSupport));
    }









}