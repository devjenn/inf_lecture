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
	
	
	//�������� "hello!!"�� ���� �޾Ҵٸ�,
	//�̹����� �ܺ�(��)���� �Ķ���͸� ���� ����
	//model�� �Ѱ���� ��(model�� ������ �信�� �������� �� ��)
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name); //�Ķ���ͷ� �Ѿ�� name�� �Ѱ���
		return "hello-template";
	}
	

}
