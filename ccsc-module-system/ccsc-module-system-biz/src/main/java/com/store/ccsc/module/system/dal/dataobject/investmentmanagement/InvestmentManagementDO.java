package com.store.ccsc.module.system.dal.dataobject.investmentmanagement;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.store.ccsc.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 工程投资管理 DO
 *
 * @author 张明明
 */
@TableName("engineering_investment_management")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentManagementDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 序号
     */
    private Integer serialNumber;
    /**
     * 投资渠道
     */
    private String investmentChannel;

    /**
     * 批次编号 如果是Excel导入的，批次号为导入时间的字符串 2026-03-21-09-33-10，手动添加的为9999
     */
    private String batchNumber;
    /**
     * 项目编号
     */
    private String ProjectNo;
    /**
     * 工程编号
     */
    private String engineeringNo;
    /**
     * 工程名称
     */
    private String engineeringName;
    /**
     * 建设单位
     */
    private String constructionUnit;
    /**
     * 工程状态
     */
    private String engineeringStatus;
    /**
     * 工程管理员
     */
    private String engineeringManager;
    /**
     * 一级专业
     */
    private String firstLevelMajor;
    /**
     * 二级专业
     */
    private String secondLevelMajor;
    /**
     * 专业标签
     */
    private String majorTag;
    /**
     * 立项批复日期
     */
    private LocalDateTime approvalDateOfProjectInitiation;
    /**
     * 实际开工日期
     */
    private LocalDateTime actualStartDate;
    /**
     * 实际初验日期
     */
    private LocalDateTime actualPreliminaryAcceptanceDate;
    /**
     * 提交预转固日期
     */
    private LocalDateTime dateOfPreFixedAssetApplication;
    /**
     * 预转固日期
     */
    private LocalDateTime preFixedAssetDate;
    /**
     * 实际终验日期
     */
    private LocalDateTime actualFinalAcceptanceDate;
    /**
     * 提交决算／转固日期
     */
    private LocalDateTime dateOfFinalAccountFixedAssetTransfer;
    /**
     * 转固日期
     */
    private LocalDateTime fixedAssetTransferDate;
    /**
     * 工程总投资(元)
     */
    private BigDecimal totalProjectInvestment;
    /**
     * 施工单位
     */
    private String constructionCompany;
    /**
     * 施工金额(含增值税)(元)
     */
    private BigDecimal constructionAmountIncludingVat;
    /**
     * 设计单位
     */
    private String designCompany;
    /**
     * 设计金额(含增值税)(元)
     */
    private BigDecimal designAmountIncludingVat;
    /**
     * 监理单位
     */
    private String supervisionCompany;
    /**
     * 监理金额(含增值税)(元)
     */
    private BigDecimal supervisionAmountIncludingVat;
    /**
     * 累计完成投资(元)
     */
    private BigDecimal cumulativeCompletedInvestment;
    /**
     * 本年完成投资(元)
     */
    private BigDecimal currentYearCompletedInvestment;
    /**
     * 本年投资(元)
     */
    private BigDecimal currentYearInvestment;
    /**
     * 工程关闭日期
     */
    private LocalDateTime projectCloseDate;

    /**
     * 审计状态(0:待审计,1:已审计)
     */
    private String auditStatus;

}