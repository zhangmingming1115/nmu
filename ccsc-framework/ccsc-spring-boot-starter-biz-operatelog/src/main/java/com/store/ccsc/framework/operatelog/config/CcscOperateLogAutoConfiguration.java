package com.store.ccsc.framework.operatelog.config;

import com.store.ccsc.framework.operatelog.core.aop.OperateLogAspect;
import com.store.ccsc.framework.operatelog.core.service.OperateLogFrameworkService;
import com.store.ccsc.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.store.ccsc.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class CcscOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
