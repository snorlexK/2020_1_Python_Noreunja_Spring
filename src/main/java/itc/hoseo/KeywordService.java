package itc.hoseo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KeywordService {
	@Autowired
	@Qualifier("db")
	private KeywordRepository repo;
	
	public KeywordRepository getRepo() {
		return repo;
	}
	
	public void setRepo(KeywordRepository repo) {
		this.repo = repo;
	}
	
	public List<Keyword> list(String platform){
		List<Keyword> keywords = new ArrayList<Keyword>();
		try {
			keywords = repo.list(platform);
		} catch(Exception e) {
			log.debug("검색어 목록 로딩 중 오류 발생");
		}
		return keywords;
	}
	
	public List<Keyword> searchByTime(String platform, String time){
		List<Keyword> keywords = new ArrayList<Keyword>();
		try {
			keywords = repo.searchByTime(platform, time);
		} catch(Exception e) {
			log.debug("검색어 검색 중 오류 발생");
		}
		return keywords;
	}
	
	public String searchByKeyword(String platform, String keyword){
		String url = "";
		try {
			url = repo.searchByKeyword(platform, keyword);
		} catch(Exception e) {
			log.debug("검색어 검색 중 오류 발생");
		}
		return url;
	}
}
