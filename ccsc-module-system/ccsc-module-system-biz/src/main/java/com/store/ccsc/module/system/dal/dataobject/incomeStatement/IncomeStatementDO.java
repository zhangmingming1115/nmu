package com.store.ccsc.module.system.dal.dataobject.incomeStatement;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.store.ccsc.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 收入清单 DO
 *
 * @author zhangmingming
 */
@TableName("income_statement")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatementDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 工程编号
     */
    private String engineeringNo;

    /**
     * 工程名称
     */
    @TableField(exist = false)
    private String engineeringName;
    /**
     * 工程管理员
     */
    @TableField(exist = false)
    private String engineeringManager;
    /**
     * 施工单位
     */
    @TableField(exist = false)
    private String constructionCompany;

    /**
     * 通服项目编号
     */
    private String tfsProjectCode;
    /**
     * 专业
     */
    private String major;
    /**
     * 项目经理
     */
    private String projectManager;
    /**
     * 工队
     */
    private String workTeam;
    /**
     * 电信应付款
     */
    private BigDecimal telecomPayable;
    /**
     * 付款月份
     */
    private String payMonth;
    /**
     * 电信付款
     */
    private BigDecimal telecomPaid;
    /**
     * 农民工直付
     */
    private String migrantWorker;
    /**
     * 通服应收款
     */
    private BigDecimal tfsReceivable;
    /**
     * 通服已收款
     */
    private BigDecimal tfsReceived;
    /**
     * 通服应收款-已收款
     */
    private BigDecimal tfsDiff;
    /**
     * 应收账款
     */
    private BigDecimal receivable;
    /**
     * 送审金额
     */
    private BigDecimal submitAmount;
    /**
     * 乙供材报审
     */
    private BigDecimal supplierMaterialSubmit;
    /**
     * 送审技工
     */
    private BigDecimal submitSkilledWorker;
    /**
     * 送审普工
     */
    private BigDecimal submitGeneralWorker;
    /**
     * 审定金额
     */
    private BigDecimal checkedAmount;
    /**
     * 乙供材审定
     */
    private BigDecimal supplierMaterial;
    /**
     * 审定技工
     */
    private BigDecimal checkedSkilledWorker;
    /**
     * 审定普工
     */
    private BigDecimal checkedGeneralWorker;
    /**
     * 安全生产费
     */
    private BigDecimal safetyFee;
    /**
     * 赔补费
     */
    private BigDecimal compensationFee;
    /**
     * 协调费搬运费
     */
    private BigDecimal coordinationFee;
    /**
     * 分包比例
     */
    private BigDecimal subcontractRatio;
    /**
     * 立项金额（含税）
     */
    private BigDecimal projectApprovedAmountTax;
    /**
     * 立项金额（不含税）
     */
    private BigDecimal projectApprovedAmount;
    /**
     * 毛利率
     */
    private BigDecimal grossProfitRate;
    /**
     * 立项成本
     */
    private BigDecimal projectCost;
    /**
     * 人工
     */
    private BigDecimal laborCost;
    /**
     * 分包费（含税）
     */
    private BigDecimal subcontractFeeTax;
    /**
     * 外包人员工资
     */
    private BigDecimal outsourceSalary;
    /**
     * 现场费
     */
    private BigDecimal siteFee;
    /**
     * 劳务工价
     */
    private BigDecimal laborPrice;
    /**
     * 施工费
     */
    private BigDecimal constructionFee;





















    /**
     * 项目编码核对
     */
    private String projectCodeChecking;
    /**
     * 项目收入
     */
    private BigDecimal projectIncome;
    /**
     * 利润
     */
    private BigDecimal profit;
    /**
     * 可用其他成本
     */
    private BigDecimal otherCost;
    /**
     * 利润率
     */
    private BigDecimal profitRate;
    /**
     * 人工占比
     */
    private BigDecimal laborRatio;
    /**
     * 现场费占比
     */
    private BigDecimal siteFeeRatio;
    /**
     * 外包费
     */
    private BigDecimal outsourceFee;
    /**
     * 综合工日单价
     */
    private BigDecimal comprehensiveWorkDayPrice;
    /**
     * 电信欠款
     */
    private BigDecimal telecomArrears;



}