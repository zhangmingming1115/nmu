package com.store.ccsc.module.system.controller.admin.investmentmanagement.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 工程投资管理 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false) // 设置 chain = false，避免用户导入有问题
public class InvestmentManagementExcelVO {

    @ExcelProperty("序号")
    private Integer serialNumber;

    @ExcelProperty("投资渠道")
    private String investmentChannel;

    @ExcelProperty("项目编号")
    private String projectNo;

    @ExcelProperty("项目名称")
    private String projectName;

    @ExcelProperty("工程编号")
    private String engineeringNo;

    @ExcelProperty("工程名称")
    private String engineeringName;

    @ExcelProperty("建设单位")
    private String constructionUnit;

    @ExcelProperty("工程状态")
    private String engineeringStatus;

    @ExcelProperty("工程管理员")
    private String engineeringManager;

    @ExcelProperty("一级专业")
    private String firstLevelMajor;

    @ExcelProperty("二级专业")
    private String secondLevelMajor;

    @ExcelProperty("专业标签")
    private String majorTag;

    @ExcelProperty("立项批复日期")
    private LocalDate approvalDateOfProjectInitiation;

    @ExcelProperty("实际开工日期")
    private LocalDate actualStartDate;

    @ExcelProperty("实际初验日期")
    private LocalDate actualPreliminaryAcceptanceDate;

    @ExcelProperty("提交预转固日期")
    private LocalDate dateOfPreFixedAssetApplication;

    @ExcelProperty("预转固日期")
    private LocalDate preFixedAssetDate;

    @ExcelProperty("实际终验日期")
    private LocalDate actualFinalAcceptanceDate;

    @ExcelProperty("提交决算／转固日期")
    private LocalDate dateOfFinalAccountFixedAssetTransfer;

    @ExcelProperty("转固日期")
    private LocalDate fixedAssetTransferDate;

    @ExcelProperty("工程总投资(元)")
    private BigDecimal totalProjectInvestment;

    @ExcelProperty("施工单位")
    private String constructionCompany;

    @ExcelProperty("施工金额(含增值税)(元)")
    private BigDecimal constructionAmountIncludingVat;

    @ExcelProperty("设计单位")
    private String designCompany;

    @ExcelProperty("设计金额(含增值税)(元)")
    private BigDecimal designAmountIncludingVat;

    @ExcelProperty("监理单位")
    private String supervisionCompany;

    @ExcelProperty("监理金额(含增值税)(元)")
    private BigDecimal supervisionAmountIncludingVat;

    @ExcelProperty("累计完成投资(元)")
    private BigDecimal cumulativeCompletedInvestment;

    @ExcelProperty("本年完成投资(元)")
    private BigDecimal currentYearCompletedInvestment;

    @Schema(description = "本年投资(元)")
    @ExcelProperty("本年投资(元)")
    private BigDecimal currentYearInvestment;

    @ExcelProperty("工程关闭日期")
    private LocalDate projectCloseDate;

    /**
     * 返回模板导出数据
     * @return
     */
    public static InvestmentManagementExcelVO getExportData() {
        return InvestmentManagementExcelVO.builder().
                serialNumber(235).
                investmentChannel("股份公司").
                projectNo("G12A2AB4057SLS").
                projectName("商州区建行交接区垃圾转运站等6项FTTH改造工程").
                engineeringNo("12A2AB4057SLS").
                engineeringName("商州区建行交接区垃圾转运站等6项FTTH改造工程").
                constructionUnit("商洛分公司").
                engineeringStatus("工程已关闭").
                engineeringManager("张勇").
                firstLevelMajor("有线接入网").
                secondLevelMajor("").
                majorTag("").
                approvalDateOfProjectInitiation(LocalDate.parse("2012-12-31")).
                actualStartDate(LocalDate.parse("2012-12-21")).
                actualPreliminaryAcceptanceDate(LocalDate.parse("2016-06-14")).
                dateOfPreFixedAssetApplication(LocalDate.parse("2016-10-25")).
                preFixedAssetDate(LocalDate.parse("2016-12-08")).
                actualFinalAcceptanceDate(LocalDate.parse("2016-06-14")).
                dateOfFinalAccountFixedAssetTransfer(LocalDate.parse("2017-12-07")).
                fixedAssetTransferDate(LocalDate.parse("2017-12-15")).
                totalProjectInvestment(BigDecimal.valueOf(46503.6)).
                constructionCompany("陕西通信建设有限公司").
                constructionAmountIncludingVat(BigDecimal.valueOf(11326.44)).
                designCompany("陕西通信规划设计研究院有限公司").
                designAmountIncludingVat(BigDecimal.valueOf(1474.46)).
                supervisionCompany("陕西中基项目管理有限公司").
                supervisionAmountIncludingVat(BigDecimal.valueOf(174.33)).
                cumulativeCompletedInvestment(BigDecimal.valueOf(1000000)).
                currentYearCompletedInvestment(BigDecimal.valueOf(1000000)).
                currentYearInvestment(BigDecimal.valueOf(1000000)).
                projectCloseDate(LocalDate.parse("2017-12-15")).build();
    }

}