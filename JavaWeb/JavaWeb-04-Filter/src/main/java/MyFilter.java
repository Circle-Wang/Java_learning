import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter implements Filter {

    // 初始化的Filter的时候执行的方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        System.out.println("===初始化Filter===");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 配置处理乱码
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("过滤开始执行");
        // 调用过滤链的下一个过滤器直到最后一个过滤器
        // 这条必须要写，否则不会这些对象传递出去
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤结束");

    }

    // 当过滤器被销毁时执行的方法
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
