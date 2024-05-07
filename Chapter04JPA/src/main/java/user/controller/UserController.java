package user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import user.bean.UserDTO;
import user.service.UserService;


@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@PostMapping(value="write")
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
//	@PostMapping(value="isExistId")
//	@ResponseBody
//	public String isExistId(@RequestParam(value="id") String id) {
//		return userService.isExistId(id);
//	}
//	@GetMapping(value="list")
//	public String list(@RequestParam(value="pg", required = false, defaultValue = "1")String pg, Model model) {
//		System.out.println("pg = " + pg);
//		model.addAttribute("pg", pg);
//		return "user/list";
//	}
//	@PostMapping(value="getUserList")	
//	@ResponseBody
//	public Map<String,Object> getUserList(@RequestParam(value="pg") String pg) {
//		return userService.getUserList(pg);
//	}
}
