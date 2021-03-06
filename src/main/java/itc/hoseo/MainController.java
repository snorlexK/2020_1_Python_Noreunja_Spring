package itc.hoseo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@Autowired
	private KeywordService keywordService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String main(ModelMap mm) {
		List<Keyword> keywords = keywordService.list("google"); 
		keywords.addAll(keywordService.list("nate"));
		keywords.addAll(keywordService.list("zum"));
		mm.put("list", keywords);
		return "list";
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String searchByTime(ModelMap mm, String platform, String time) {
		List<Keyword> keywords = keywordService.list("google"); 
		keywords.addAll(keywordService.list("nate"));
		keywords.addAll(keywordService.list("zum"));
		keywords.addAll(keywordService.searchByTime(platform, time));
		mm.put("list", keywords);
		return "list";
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String searchByKeyword(ModelMap mm, String platform, String keyword) {
		mm.put("search", keywordService.searchByKeyword(platform, keyword));
		return "search";
	}
}
