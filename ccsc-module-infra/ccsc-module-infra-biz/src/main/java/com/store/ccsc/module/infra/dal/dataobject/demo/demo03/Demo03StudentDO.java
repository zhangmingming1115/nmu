package com.store.ccsc.module.infra.dal.dataobject.demo.demo03;

import com.sun.xml.bind.v2.TODO;
import lombok.*;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import com.store.ccsc.framework.mybatis.core.dataobject.BaseDO;

/**
 * 学生 DO
 *
 */
@TableName("infra_demo03_student")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo03StudentDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     *
     * 枚举 {@link TODO system_user_sex 对应的类}
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private LocalDateTime birthday;
    /**
     * 简介
     */
    private String description;

}