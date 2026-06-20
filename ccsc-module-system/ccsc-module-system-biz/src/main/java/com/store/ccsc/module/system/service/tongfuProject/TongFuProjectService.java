package com.store.ccsc.module.system.service.tongfuProject;

import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.module.system.controller.admin.tongfuProject.vo.TongFuProjectExcelVO;
import com.store.ccsc.module.system.controller.admin.tongfuProject.vo.TongFuProjectImportRespVO;
import com.store.ccsc.module.system.controller.admin.tongfuProject.vo.TongFuProjectPageReqVO;
import com.store.ccsc.module.system.controller.admin.tongfuProject.vo.TongFuProjectSaveReqVO;
import com.store.ccsc.module.system.dal.dataobject.incomeStatement.IncomeStatementDO;
import com.store.ccsc.module.system.dal.dataobject.tongfuProject.TongFuProjectDO;

import javax.validation.Valid;
import java.util.List;

/**
 * 通服项目 Service 接口
 *
 * @author 张明明
 */
public interface TongFuProjectService {

    /**
     * 创建通服项目
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTongFuProject(@Valid TongFuProjectSaveReqVO createReqVO);

    /**
     * 更新通服项目
     *
     * @param updateReqVO 更新信息
     */
    void updateTongFuProject(@Valid TongFuProjectSaveReqVO updateReqVO);

    /**
     * 删除通服项目
     *
     * @param id 编号
     */
    void deleteTongFuProject(Long id);

    /**
     * 获得通服项目
     *
     * @param id 编号
     * @return 通服项目
     */
    TongFuProjectDO getTongFuProject(Long id);

    /**
     * 获得通服项目分页
     *
     * @param pageReqVO 分页查询
     * @return 通服项目分页
     */
    PageResult<TongFuProjectDO> getTongFuProjectPage(TongFuProjectPageReqVO pageReqVO);

    /**
     *
     * @param tongFuProjectId
     * @return
     */
    IncomeStatementDO getIncomeStatementData(Long tongFuProjectId);

    TongFuProjectImportRespVO importTongFuProjectList(List<TongFuProjectExcelVO> list, Boolean updateSupport);




}