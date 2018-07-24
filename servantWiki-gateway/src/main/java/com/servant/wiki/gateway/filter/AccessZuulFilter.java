package com.servant.wiki.gateway.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.servant.wiki.gateway.service.ConfigService;
import com.servant.wiki.gateway.service.SecrityService;

import net.sf.json.JSONObject;


@Component
public class AccessZuulFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessZuulFilter.class);

    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private SecrityService secrityService;

    static {
        //patterns.add(Pattern.compile("/"));
        patterns.add(Pattern.compile("wechat/[^\\s]*"));
        patterns.add(Pattern.compile("doc/[^\\s]*"));
        patterns.add(Pattern.compile("register/[^\\s]*"));
        patterns.add(Pattern.compile("eureka/[^\\s]*"));
        patterns.add(Pattern.compile("MP_verify_5cHTArAG07bPxp89.txt"));
        patterns.add(Pattern.compile("MP_verify_q07u1aRChmD7i3nx.txt"));
    }

    @Value("${cookie.domain}")
    private String cookieDomain;

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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        return isFilter(getUrl(request));
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setContentType("application/json; charset=utf-8");

        String url = request.getRequestURL().toString();
        log.info("{} request to {}", request.getMethod(), url);
        log.info("paramterMap {}",
            JSONObject.fromObject(request.getParameterMap()).toString());

        return null;
    }

    /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isFilter(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return false;
            }
        }
        return true;
    }

    private String getUrl(HttpServletRequest request) {
        String url = request.getRequestURI()
                            .substring(request.getContextPath().length());
        if (url.startsWith("/") && (url.length() > 1)) {
            url = url.substring(1);
        }
        return url;
    }

}
