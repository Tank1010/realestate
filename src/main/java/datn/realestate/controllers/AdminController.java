package datn.realestate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cms")
public class AdminController {
	@RequestMapping("/adminlogin")
	public String adminloginpage() {
		return "/cms/adminlogin";
	}
	
	@RequestMapping("/access-denied")
	public String access_denied(RedirectAttributes attributes) {
		attributes.addFlashAttribute("error", true);
		attributes.addFlashAttribute("message", "You Don't have permission");
		return "redirect:/Admin/error-404";
	}

	@RequestMapping("/error-404")
	public String error_404() {
		return "websites/error";

	}

	@RequestMapping("/adminlogout")
	public String adminlogoutpage() {

		return "/cms/adminlogout";
	}
}
