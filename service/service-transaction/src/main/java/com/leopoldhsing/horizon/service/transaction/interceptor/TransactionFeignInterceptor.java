package com.leopoldhsing.horizon.service.transaction.interceptor;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class TransactionFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        long uid = RequestUtil.getUid();
        requestTemplate.header("uid", String.valueOf(uid));
    }
}
