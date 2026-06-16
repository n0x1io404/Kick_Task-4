package by.n0x1.task.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * Filter for intercepting request to prevent XSS according to task instructions.
 */
@WebFilter("/*")
public class XssFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XssRequestWrapper((HttpServletRequest) request), response);
    }
    
    private static class XssRequestWrapper extends HttpServletRequestWrapper {
        public XssRequestWrapper(HttpServletRequest req) { super(req); }
        
        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            return cleanXSS(value);
        }
        
        private String cleanXSS(String value) {
            if (value == null) return null;
            return value.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                        .replaceAll("'", "&#39;").replaceAll("\"", "&quot;");
        }
    }
}
