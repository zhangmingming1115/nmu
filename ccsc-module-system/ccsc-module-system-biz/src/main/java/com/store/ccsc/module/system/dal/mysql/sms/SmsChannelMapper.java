package com.store.ccsc.module.system.dal.mysql.sms;

import com.store.ccsc.framework.common.pojo.PageResult;
import com.store.ccsc.framework.mybatis.core.mapper.BaseMapperX;
import com.store.ccsc.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.store.ccsc.module.system.controller.admin.sms.vo.channel.SmsChannelPageReqVO;
import com.store.ccsc.module.system.dal.dataobject.sms.SmsChannelDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsChannelMapper extends BaseMapperX<SmsChannelDO> {

    default PageResult<SmsChannelDO> selectPage(SmsChannelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SmsChannelDO>()
                .likeIfPresent(SmsChannelDO::getSignature, reqVO.getSignature())
                .eqIfPresent(SmsChannelDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SmsChannelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SmsChannelDO::getId));
    }

    default SmsChannelDO selectByCode(String code) {
        return selectOne(SmsChannelDO::getCode, code);
    }

}
