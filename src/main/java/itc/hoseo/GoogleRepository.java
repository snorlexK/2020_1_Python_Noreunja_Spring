package itc.hoseo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.SQLInsert;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("db")
public class GoogleRepository {	
	public GoogleRepository() {
		
	}
	
	public Connection dbConnect() throws Exception {
		return DriverManager.getConnection("jdbc:h2:mem:myDb", "sa", "sa");
	}
	
	public List<Google> list() {
		List<Google> googles = new ArrayList<Google>();
		String sql = "select * from google";
		try (Connection con = dbConnect(); PreparedStatement pstmt =  con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Google google = Google.builder()
						.id(rs.getInt(1))
						.keyword(rs.getString(2))
						.rank(rs.getInt(3))
						.time(rs.getDate(4))
						.build();
				
				googles.add(google);
			}
		} catch(Exception e) {
			log.error("목록 불러오기 오류", e);
		}
		return googles;
	}
}
