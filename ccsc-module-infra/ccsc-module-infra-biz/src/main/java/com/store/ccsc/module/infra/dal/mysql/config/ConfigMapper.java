package com.store.ccsc.module.infra.dal.mysql.config;

import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.mybatis.core.mapper.BaseMapperX;
import com.store.ccsc.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.store.ccsc.module.infra.controller.admin.config.vo.ConfigPageReqVO;
import com.store.ccsc.module.infra.dal.dataobject.config.ConfigDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigMapper extends BaseMapperX<ConfigDO> {

    default ConfigDO selectByKey(String key) {
        return selectOne(ConfigDO::getConfigKey, key);
    }

    default PageResult<ConfigDO> selectPage(ConfigPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ConfigDO>()
                .likeIfPresent(ConfigDO::getName, reqVO.getName())
                .likeIfPresent(ConfigDO::getConfigKey, reqVO.getKey())
                .eqIfPresent(ConfigDO::getType, reqVO.getType())
                .betweenIfPresent(ConfigDO::getCreateTime, reqVO.getCreateTime()));
    }

}
