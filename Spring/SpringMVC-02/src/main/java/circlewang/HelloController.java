package circlewang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// 使用注释的方式构造自己的控制器
@Controller
@RequestMapping("/api")            // 当前类下所有的url都需要拼接/api(一般可以不用)
public class HelloController {

    @RequestMapping("/helloUrl")      // 当前端访问/api/helloUrl时就会进入到当前方法
    public String hello(Model model) {
        // 封装数据(之前是使用ModelAndView.addObject)
        model.addAttribute("msg","传递给前端的数据");

        return "helloJSP";   // 此处返回的字符串会进入视图解析器，从而"转发"到/WEB-INF/jsp/helloJSP.jsp中
    }
}
