package com.store.ccsc.module.system.service.investmentmanagement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementExcelVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementImportRespVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementPageReqVO;
import com.store.ccsc.module.system.controller.admin.investmentmanagement.vo.InvestmentManagementSaveReqVO;
import com.store.ccsc.module.system.dal.dataobject.investmentmanagement.InvestmentManagementDO;

import javax.validation.Valid;
import java.util.List;

/**
 * 工程投资管理 Service 接口
 *
 * @author 张明明
 */
public interface InvestmentManagementService extends IService<InvestmentManagementDO> {

    /**
     * 创建工程投资管理
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInvestmentManagement(@Valid InvestmentManagementSaveReqVO createReqVO);

    /**
     * 更新工程投资管理
     *
     * @param updateReqVO 更新信息
     */
    void updateInvestmentManagement(@Valid InvestmentManagementSaveReqVO updateReqVO);

    /**
     * 删除工程投资管理
     *
     * @param id 编号
     */
    void deleteInvestmentManagement(Long id);

    /**
     * 获得工程投资管理
     *
     * @param id 编号
     * @return 工程投资管理
     */
    InvestmentManagementDO getInvestmentManagement(Long id);

    /**
     * 获得工程投资管理分页
     *
     * @param pageReqVO 分页查询
     * @return 工程投资管理分页
     */
    PageResult<InvestmentManagementDO> getInvestmentManagementPage(InvestmentManagementPageReqVO pageReqVO);

    /**
     * 导入工程投资管理列表
     *
     * @param list 文件列表
     * @param updateSupport 是否支持更新
     * @return 导入结果
     */
    InvestmentManagementImportRespVO importInvestmentManagementList(List<InvestmentManagementExcelVO> list, Boolean updateSupport);

    /**
     * 获得批次号列表
     *
     * @return 批次号列表
     */
    List<String> getBatchNumberList();

    /**
     * 返回工程状态所有值
     * @return
     */
    List<String> getEngineeringStatusList();


    /**
     * 一级专业下拉框
     * @return
     */
    List<String> getFirstLevelMajorList();

    /**
     * 施工单位下拉框
     * @return
     */
    List<String> getConstructionCompanyList();

    InvestmentManagementDO getByEngineeringNo(String engineeringNo);
}