package com.store.ccsc.module.system.controller.admin.incomeStatement;

import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.module.system.controller.admin.incomeStatement.vo.*;
import com.store.ccsc.module.system.dal.dataobject.incomeStatement.IncomeStatementDO;
import com.store.ccsc.module.system.service.incomeStatement.IncomeStatementService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.io.IOException;
import java.util.List;

import com.store.ccsc.framework.common.pojo.PageParam;
import com.store.ccsc.framework.common.pojo.CommonResult;
import com.store.ccsc.framework.common.util.object.BeanUtils;
import static com.store.ccsc.framework.common.pojo.CommonResult.success;

import com.store.ccsc.framework.excel.core.util.ExcelUtils;

import com.store.ccsc.framework.operatelog.core.annotations.OperateLog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.store.ccsc.framework.operatelog.core.enums.OperateTypeEnum.*;


@Tag(name = "管理后台 - 收入清单")
@RestController
@RequestMapping("/incomeStatement")
@Validated
public class IncomeStatementController {

    @Resource
    private IncomeStatementService service;

    @PostMapping("/create")
    @Operation(summary = "创建收入清单")
    @PreAuthorize("@ss.hasPermission('incomeStatement::create')")
    public CommonResult<Long> create(@Valid @RequestBody IncomeStatementSaveReqVO createReqVO) {
        return success(service.create(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新收入清单")
    @PreAuthorize("@ss.hasPermission('incomeStatement::update')")
    public CommonResult<Boolean> update(@Valid @RequestBody IncomeStatementSaveReqVO updateReqVO) {
        service.update(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除收入清单")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('incomeStatement::delete')")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        service.delete(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得收入清单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('incomeStatement::query')")
    public CommonResult<IncomeStatementRespVO> get(@RequestParam("id") Long id) {
        IncomeStatementDO  statementDO= service.get(id);
        return success(BeanUtils.toBean(statementDO, IncomeStatementRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得收入清单分页")
    @PreAuthorize("@ss.hasPermission('incomeStatement::query')")
    public CommonResult<PageResult<IncomeStatementRespVO>> getPage(@Valid IncomeStatementPageReqVO pageReqVO) {
        PageResult<IncomeStatementDO> pageResult = service.getPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IncomeStatementRespVO.class));
    }

    @GetMapping("/exportExcel")
    @Operation(summary = "导出收入清单 Excel")
    @PreAuthorize("@ss.hasPermission('incomeStatement::export')")
    @OperateLog(type = EXPORT)
    public void exportExcel(@Valid IncomeStatementPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<IncomeStatementDO> list = service.getPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "收入清单.xls", "数据", IncomeStatementRespVO.class,
                        BeanUtils.toBean(list, IncomeStatementRespVO.class));
    }




}