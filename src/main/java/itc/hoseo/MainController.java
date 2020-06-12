package itc.hoseo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@Autowired
	private GoogleService googleService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String main(ModelMap mm) {
		mm.put("list", googleService.list());
		return "list";
	}
}
