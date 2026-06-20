package com.store.ccsc.module.system.dal.dataobject.tongfuProject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import com.store.ccsc.framework.mybatis.core.dataobject.BaseDO;

/**
 * 通服项目 DO
 *
 * @author 张明明
 */
@TableName("tongfu_project")
@KeySequence("tongfu_project_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TongFuProjectDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 通服项目编号
     */
    private String tfsProjectCode;

    /**
     * 工程名称
     */
    private String engineeringName;

    /**
     * 甲方项目编号(工程编号)
     */
    private String engineeringNo;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 项目经理名称
     */
    private String projectManager;
    /**
     * 经办人
     */
    private String operator;
    /**
     * 计划收入(含税)
     */
    private BigDecimal plannedIncomeTax;
    /**
     * 计划收入(不含税)
     */
    private BigDecimal plannedIncomeNoTax;
    /**
     * 累计开票(含税)   CA
     */
    private BigDecimal totalInvoicedTax;
    /**
     * 累计开票(不含税)
     */
    private BigDecimal totalInvoicedNoTax;
    /**
     * 项目收入合同金额(不含税)
     */
    private BigDecimal contractIncomeNoTax;
    /**
     * 列账收入(含税)
     */
    private BigDecimal recordIncomeTax;
    /**
     * 列账收入(未税)
     */
    private BigDecimal recordIncomeNoTax;
    /**
     * 累计收款(含税)  BZ
     */
    private BigDecimal totalReceivedTax;
    /**
     * 审定金额（不含税）
     */
    private BigDecimal checkedAmountNoTax;
    /**
     * 计划成本
     */
    private BigDecimal plannedCost;
    /**
     * 材料费成本
     */
    private BigDecimal materialCost;
    /**
     * 外包/合作费成本
     */
    private BigDecimal outsourcingCost;
    /**
     * 其他费成本
     */
    private BigDecimal otherCost;
    /**
     * 人工成本
     */
    private BigDecimal laborCost;
    /**
     * 累计收票(含税)
     */
    private BigDecimal totalInvoiceReceivedTax;
    /**
     * 实际成本
     */
    private BigDecimal actualCost;
    /**
     * 实际人工成本
     */
    private BigDecimal actualLaborCost;
    /**
     * 实际材料成本
     */
    private BigDecimal actualMaterialCost;
    /**
     * 实际外包成本
     */
    private BigDecimal actualOutsourcingCost;
    /**
     * 实际其他成本
     */
    private BigDecimal actualOtherCost;
    /**
     * 累计付款(含税)
     */
    private BigDecimal totalPaidTax;
    /**
     * 计划毛利率%
     */
    private BigDecimal plannedGrossProfitRate;
    /**
     * 实际毛利率%
     */
    private BigDecimal actualGrossProfitRate;
    /**
     * 批次编号 如果是Excel导入的，批次号为导入时间的字符串 2026-03-21-09-33-10，手动添加的为9999
     */
    private String batchNumber;







    /**
     * 负责部门编号  6100240004
     */
    private String responsibleDepartment;

    /**
     * 专业类型名称  professional_type_name  工程施工-管线工程-通信线路施工-线路
     */
    private String professionalTypeName;


    /**
     * 所属公司  陕西省通信服务有限公司商洛分公司
     */
    private String affiliatedCompany;

    /**
     * 项目结项状态
     */
    private String projectClosureStatus;



}