package com.store.ccsc.module.infra.dal.mysql.db;

import com.store.ccsc.framework.mybatis.core.mapper.BaseMapperX;
import com.store.ccsc.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
