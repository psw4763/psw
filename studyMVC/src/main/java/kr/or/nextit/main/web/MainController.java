package kr.or.nextit.main.web;

import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.HomeController;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value= {"/index.do"})
	public String MainForm(
			@RequestParam HashMap<String, Object> param,
			Model model,
			ModelMap modelmap,
			Locale locale) {
		
		logger.debug("param = {}",param);
		logger.debug("Locale = {}",locale.getLanguage());
		
		model.addAttribute("nugu","나야 ~~");
		model.addAttribute("name","홍길동");
		
		return "main/mainForm";
	}
	
}
