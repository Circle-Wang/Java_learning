

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    // 我们可以从HttpServletRequest对象中获得前端传输的消息（也就是发送请求的内容）
    // 我们也可以将我们的信息通过HttpServletResponse显示到前端（发送给前端）

    // 当接收到get请求时会执行该方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.getOutputStream(): 获得输出流对象
        // req.getInputStream(): 获得输入流对象
        System.out.println("进入了get方法");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();  // 得到前端页面输出对象
        writer.print("这是Servlet类返回的消息: helloServlet");

    }

    // 当接收到post请求时会执行该方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
