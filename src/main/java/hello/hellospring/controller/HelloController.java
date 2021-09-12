package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!!");
		return "hello";
	}
	
	
	//위에서는 "hello!!"를 직접 받았다면,
	//이번에는 외부(웹)에서 파라메터를 받을 것임
	//model은 넘겨줘야 함(model을 잡으면 뷰에서 렌더링할 때 씀)
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name); //파라메터로 넘어온 name을 넘겨줌
		return "hello-template";
	}
	

}
