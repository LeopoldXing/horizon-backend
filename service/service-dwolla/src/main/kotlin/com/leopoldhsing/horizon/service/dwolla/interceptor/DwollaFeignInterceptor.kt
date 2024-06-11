package com.leopoldhsing.horizon.service.dwolla.interceptor

import com.leopoldhsing.horizon.common.utils.RequestUtil
import com.leopoldhsing.horizon.common.utils.constants.GatewayConstants
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.stereotype.Component

@Component
class DwollaFeignInterceptor : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate?) {
        val uid = RequestUtil.getUid()
        requestTemplate?.header(GatewayConstants.USERID_HEADER_KEY, uid.toString())
    }
}
