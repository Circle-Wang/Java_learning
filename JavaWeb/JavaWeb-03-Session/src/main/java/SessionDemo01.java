import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 获得Session对象
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        writer.write("SessionID为：" + session.getId());

        // 在Session中添加数据
        session.setAttribute("用户名", "CircleWang");
        session.setAttribute("密码", "123456");
    }
}
