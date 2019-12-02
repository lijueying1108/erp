package org.kor.mv.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping("/hellworld")
	@ResponseBody
	public String HelloWorld() {
		return "Hello World";
	}
}
