package circlewang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping("/add")
    public String add(int a, int b, Model model) {  // 前端可以使用?a=xxx&b=xxx的方式进行传参, 尽量抛弃这种方式
        System.out.println("前端传入的参数是:"+ a + " " + b);
        int sum = a + b;
        model.addAttribute("msg",sum);  // 将计算后的参数传递给前端
        return "helloJSP";
    }

    @RequestMapping("/requestParam")    // 前端可以使用?num1=xxx&num2=xxx的方式进行传参
    public String test1(@RequestParam("num1") int a, @RequestParam("num2") int b , Model model) {
        System.out.println("前端传入的参数是:"+ a + " " + b);
        int sum = b + a;
        model.addAttribute("msg", sum);
        return "helloJSP";
    }

    @RequestMapping("/pathVariable/{a}/{b}")    // 前端直接访问/pathVariable/xxx/xxx即可完成参数传递
    public String test1(@PathVariable int a, @PathVariable String b , Model model) {
        String sum = b + a;
        model.addAttribute("msg", sum);
        return "helloJSP";
    }


    @RequestMapping(path="/GETMethod/{a}", method=RequestMethod.GET)  // 只能通过Get方式进行提交
    public String test2(@PathVariable Integer a, Model model) {
        model.addAttribute("msg", a);
        return "helloJSP";
    }

    @PostMapping(path="/PostMethod/{a}")  // 只能通过post方式进行提交(浏览器默认是使用get请求的)
    public String test3(@PathVariable Integer a, Model model) {
        model.addAttribute("msg", a);
        return "helloJSP";
    }


    @GetMapping("/forward")
    public String test3(Model model) {
        model.addAttribute("msg", "这是转发得到的页面");
        System.out.println("进入到转发请求");
        return "forward: /api/helloUrl";  // 注意这里不能写/helloUrl
    }

    @GetMapping("/redirect")
    public String test4() {
        System.out.println("进入重定向模块");
        return "redirect:/other.jsp";  // 注意无法访问WEB-INF的资源，因为本质上重定向是告诉客户端，让客户端去访问资源, 因此客户端无法直接访问到WEB-INF的内容
    }


}
