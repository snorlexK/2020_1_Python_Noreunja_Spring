package itc.hoseo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class NoreunjaApplicationTests {
	
	@Autowired
	private GoogleRepository repo;
	
	@BeforeEach
	public void init() {
		//repo.save(new Google(null, "테스트", 0, new Date()));
	}

	@Test
	public void test() {
		//assertEquals(1, repo.findAll(PageRequest.of(0, 10)).size());
	}

}
