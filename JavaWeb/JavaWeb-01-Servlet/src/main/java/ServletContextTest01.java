import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletContextTest01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext(); // 获得ServletContext对象

        String user = context.getInitParameter("user"); // 读取web.xml配置文中的数据
        context.setAttribute("用户名", user); // 将数据放入context
        System.out.println("完成数据读取与存入, 开始请求转发");
        // 并将请求转发到其他的url，注意这里的/代表当前的web应用
        context.getRequestDispatcher("/context02").forward(req, resp);


    }
}
