package tech.yashchenkon.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import tech.yashchenkon.api.LoggingRule;
import tech.yashchenkon.request.RequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mykola Yashchenko
 */
public class RequestLoggingFilter extends OncePerRequestFilter {

    private LoggingRule<RequestWrapper> requestLoggingRule;

    public RequestLoggingFilter(LoggingRule<RequestWrapper> requestLoggingRule) {
        this.requestLoggingRule = requestLoggingRule;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        requestLoggingRule.logIfNecessary(new RequestWrapper(request));
        filterChain.doFilter(request, response);
    }
}
