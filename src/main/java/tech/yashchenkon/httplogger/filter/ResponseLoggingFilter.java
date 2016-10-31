package tech.yashchenkon.httplogger.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import tech.yashchenkon.httplogger.api.LoggingRule;
import tech.yashchenkon.httplogger.response.ResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mykola Yashchenko
 */
public class ResponseLoggingFilter extends OncePerRequestFilter {

    private LoggingRule<ResponseWrapper> responseLoggingRule;

    public ResponseLoggingFilter(LoggingRule<ResponseWrapper> responseLoggingRule) {
        this.responseLoggingRule = responseLoggingRule;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        responseLoggingRule.logIfNecessary(new ResponseWrapper(response));
        filterChain.doFilter(request, response);
    }
}
