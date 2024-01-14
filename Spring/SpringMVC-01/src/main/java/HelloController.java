

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        // 业务代码
        String result = "这是业务对象返回的数据";
        mv.addObject("msg", result); // 此处的"msg"可以在jsp文件中使用${}获取

        // 视图跳转(将mv发送到指定的jsp文件中，实现展示)
        mv.setViewName("test");
        System.out.print("进入到控制器");

        return mv;
    }

}
