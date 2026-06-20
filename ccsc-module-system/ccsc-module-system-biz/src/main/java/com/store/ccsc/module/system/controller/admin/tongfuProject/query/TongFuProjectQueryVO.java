package com.store.ccsc.module.system.controller.admin.tongfuProject.query;

import com.alibaba.excel.annotation.ExcelProperty;
import com.store.ccsc.framework.common.pojo.PageParam;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mmzhang
 * @email braveheart1115@163.com
 * @date 2026/4/12/012 22:36
 * @Description: 通服项目查询vo对象，包括显示字段与查询条件字段
 */
@Data
public class TongFuProjectQueryVO extends PageParam {

    // 通服项目编号
    private String tfsProjectCode;

    // 客户名称
    private String customerName;



}
