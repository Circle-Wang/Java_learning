package circle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controller1")
public class controller1 {

    @GetMapping("/hello")
    @ResponseBody   // 这个注解会把该方法的返回结果直接展示到前端, 而不经过视图解析器
    public String hello(){
        return "这是一个hello页面";
    }
}
