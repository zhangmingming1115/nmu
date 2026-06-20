package com.store.ccsc.module.system.service.incomeStatement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.module.system.controller.admin.incomeStatement.vo.IncomeStatementPageReqVO;
import com.store.ccsc.module.system.controller.admin.incomeStatement.vo.IncomeStatementSaveReqVO;
import com.store.ccsc.module.system.dal.dataobject.incomeStatement.IncomeStatementDO;

import javax.validation.Valid;

/**
 * 收入清单 Service 接口
 *
 * @author zhangmingming
 */
public interface IncomeStatementService extends IService<IncomeStatementDO> {

    /**
     * 创建收入清单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long create(@Valid IncomeStatementSaveReqVO createReqVO);

    /**
     * 更新收入清单
     *
     * @param updateReqVO 更新信息
     */
    void update(@Valid IncomeStatementSaveReqVO updateReqVO);

    /**
     * 删除收入清单
     *
     * @param id 编号
     */
    void delete(Long id);

    /**
     * 获得收入清单
     *
     * @param id 编号
     * @return 收入清单
     */
    IncomeStatementDO get(Long id);

    /**
     * 获得收入清单分页
     *
     * @param pageReqVO 分页查询
     * @return 收入清单分页
     */
    PageResult<IncomeStatementDO> getPage(IncomeStatementPageReqVO pageReqVO);


}