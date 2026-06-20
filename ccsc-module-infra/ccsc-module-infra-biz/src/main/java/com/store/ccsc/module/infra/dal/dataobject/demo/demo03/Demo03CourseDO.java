package com.store.ccsc.module.infra.dal.dataobject.demo.demo03;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import com.store.ccsc.framework.mybatis.core.dataobject.BaseDO;

/**
 * 学生课程 DO
 *
 */
@TableName("infra_demo03_course")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo03CourseDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 学生编号
     */
    private Long studentId;
    /**
     * 名字
     */
    private String name;
    /**
     * 分数
     */
    private Integer score;

}