package com.store.ccsc.module.system.controller.admin.projectDelivery.controller;

import com.store.ccsc.framework.common.pojo.CommonResult;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.common.util.object.BeanUtils;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementPageReqVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementRespVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementSaveReqVO;
import com.store.ccsc.module.system.dal.dataobject.investmentmanagement.InvestmentManagementDO;
import com.store.ccsc.module.system.service.investmentmanagement.InvestmentManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.store.ccsc.framework.common.pojo.CommonResult.success;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/3/26/026 17:46
 * @Description:
 */
@Tag(name = "工程交付")
@RestController
@RequestMapping("/engineering/projectDelivery")
@Validated
public class ProjectDeliveryController {

    @Resource
    private InvestmentManagementService investmentManagementService;

    @PostMapping("/create")
    @Operation(summary = "创建工程交付")
    @PreAuthorize("@ss.hasPermission('engineering:projectDelivery:create')")
    public CommonResult<Long> createInvestmentManagement(@Valid @RequestBody InvestmentManagementSaveReqVO createReqVO) {
        return success(investmentManagementService.createInvestmentManagement(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新工程交付")
    @PreAuthorize("@ss.hasPermission('engineering:projectDelivery:update')")
    public CommonResult<Boolean> updateInvestmentManagement(@Valid @RequestBody InvestmentManagementSaveReqVO updateReqVO) {
        investmentManagementService.updateInvestmentManagement(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除工程交付")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('engineering:projectDelivery:delete')")
    public CommonResult<Boolean> deleteInvestmentManagement(@RequestParam("id") Long id) {
        investmentManagementService.deleteInvestmentManagement(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得工程交付")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('engineering:projectDelivery:query')")
    public CommonResult<InvestmentManagementRespVO> getInvestmentManagement(@RequestParam("id") Long id) {
        InvestmentManagementDO investmentManagement = investmentManagementService.getInvestmentManagement(id);
        return success(BeanUtils.toBean(investmentManagement, InvestmentManagementRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得工程交付分页")
    @PreAuthorize("@ss.hasPermission('engineering:projectDelivery:query')")
    public CommonResult<PageResult<InvestmentManagementRespVO>> getInvestmentManagementPage(@Valid InvestmentManagementPageReqVO pageReqVO) {
        pageReqVO.setAuditStatus("0"); // 只查询待审计的数据
        PageResult<InvestmentManagementDO> pageResult = investmentManagementService.getInvestmentManagementPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, InvestmentManagementRespVO.class));
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
