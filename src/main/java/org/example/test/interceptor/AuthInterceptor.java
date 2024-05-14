package org.example.test.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义拦截器，在请求到达控制层前提前拦截器相应请求并处理请求
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    /**
     * 根据在WebConfiguration配置的请求路径进行拦截，拦截到的请求可在这提前处理，但时间不够弄token等验证了
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
