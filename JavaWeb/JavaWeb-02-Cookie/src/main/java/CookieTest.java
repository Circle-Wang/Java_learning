
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CookieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 防止中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter outer = resp.getWriter();

        // 获得浏览器的Cookie对象
        Cookie[] cookies = req.getCookies();

        // 先判定当前用户是否第一次访问该页面
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("userName")) {
                    outer.write("你上次访问当前页面时使用的用户名为：" + cookie.getValue());
                }
            }
        } else  {
            outer.write("你是第一次访问当前页面, 不存在Cookie");
        }

        // 发送Cookie
        resp.addCookie(new Cookie("userName", "CircleWang"));
    }
}
