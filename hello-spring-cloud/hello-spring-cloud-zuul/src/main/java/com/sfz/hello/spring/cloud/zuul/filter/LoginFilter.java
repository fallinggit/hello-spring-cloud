package com.sfz.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component //过滤器加容器注解
public class LoginFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**\
     * 过滤器的具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("{} >>> {}",request.getMethod(),request.getRequestURI().toString());
        String token = request.getParameter("token");//令牌
        if (token == null){
            logger.warn("Token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);//没有权限
            try {
                context.getResponse().getWriter().write("Token is empty");//响应出去
            } catch (IOException e) {
            }
        }else {
            logger.info("OK");
        }


        return null;
    }
}
