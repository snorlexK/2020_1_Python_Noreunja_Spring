package itc.hoseo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("db")
public class KeywordRepository {		
	public Connection dbConnect() throws Exception {
		return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
	}
	
	public List<Keyword> list(String platform) {
		List<Keyword> keywords = new ArrayList<Keyword>();
		String sql = "select * from (select * from " + platform
				+ " order by time desc limit 10) order by rank;";
		try (Connection con = dbConnect(); PreparedStatement pstmt =  con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Keyword keyword = Keyword.builder()
						.id(rs.getInt(1))
						.keyword(rs.getString(2))
						.rank(rs.getInt(3))
						.time(rs.getDate(4))
						.build();
				
				keywords.add(keyword);
			}
		} catch(Exception e) {
			log.error("목록 불러오기 오류", e);
		}
		return keywords;
	}
	
	public List<Keyword> searchByTime(String platform, String time) {
		List<Keyword> keywords = new ArrayList<Keyword>();
		String startTime = time + " 00:00:00";
		String endTime = time + " 23:59:59";
		String sql = "select * from " + platform
				+ " where time between ? and ? order by rank;";
		try (Connection con = dbConnect(); PreparedStatement pstmt =  con.prepareStatement(sql);) {
			pstmt.setString(1, startTime);
			pstmt.setString(2, endTime);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Keyword keyword = Keyword.builder()
						.id(rs.getInt(1))
						.keyword(rs.getString(2))
						.rank(rs.getInt(3))
						.time(rs.getDate(4))
						.build();
				
				keywords.add(keyword);
			}
		} catch(Exception e) {
			log.error("목록 불러오기 오류", e);
		}
		return keywords;
	}
	
	public String searchByKeyword(String platform, String keyword) {
		String url = "";
		if(platform.equals("google")) {
			keyword.replace(" ", "&");
			url = "https://www.google.com/search?q=" + keyword + "&oq=" + keyword;
		}
		if(platform.equals("nate")) {
			keyword.replace(" ", "%");
			url = "https://search.daum.net/nate?w=tot&m=&q=" + keyword;
		}
		if(platform.equals("zum")) {
			keyword.replace(" ", "+");
			url = "http://search.zum.com/search.zum?method=uni&option=accu&qm=g_exp&query=" + keyword;
		}
		return url;
	}
}
