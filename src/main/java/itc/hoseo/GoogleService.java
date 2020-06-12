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
public class GoogleService {
	@Autowired
	@Qualifier("db")
	private GoogleRepository repo;
	
	public GoogleRepository getRepo() {
		return repo;
	}
	
	public void setRepo(GoogleRepository repo) {
		this.repo = repo;
	}
	
	public List<Google> list(){
		List<Google> keywords = new ArrayList<Google>();
		try {
			keywords = repo.list();
		} catch(Exception e) {
			log.debug("구글 검색어 목록 로딩 중 오류 발생");
		}
		return keywords;
	}
}
