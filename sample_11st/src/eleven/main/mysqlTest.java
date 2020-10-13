package eleven.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysqlTest {
	
	public static void main(String[] args) {
		
		
		//mysql DB 연동
		String url ="jdbc:mysql://192.168.0.203:3350/test";
		String user = "vpqa01";
		String pass = "qmdlvl01!";
		
		Connection conn = null; //connection 초기화
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //DriverManager에 데이터베이스 연동 등록
			System.out.println("드라이버 검색 성공");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("접속 성공");
			
			//DB 데이터 불러오기
			//테이블 불러오기
			String qu = "select * from userinfo.USERINFO_TB"; //필요한 데이터만 뽑아서 보여주는 쿼리문: select NAME, CARD_NUMBER from userinfo_tb where DEVICE='GS8'; (GS8에 해당하는 이름, 카드넘버만 보여줌)
			
			//java statement 생성
			Statement st = conn.createStatement();
			
			//쿼리 execute, 객체형성
			ResultSet rs = st.executeQuery(qu);
			
			//각 열을 반복적으로 나타내줌
			while (rs.next()) {
				String device = rs.getString("DEVICE");
				String phone = rs.getString("PHONE");
				String name = rs.getString("NAME");
				String cardNum = rs.getString("CARD_NUMBER");
				String cardInfo = rs.getString("CARD_INFO");
				String cardPw = rs.getString("CARD_PW");
				String certDate = rs.getString("CERT_EXDATE");
				String certPw = rs.getString("CERT_PW");
				String pbPw = rs.getString("PB_PW");
				
				//결과값 도출 (%s당 id 같은 정보를 출력해 줌, %s: 문자열 형식으로 출력, \n: 줄바꿈)
				System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s\n", device, phone, name, cardNum, cardInfo, cardPw, certDate, certPw, pbPw);
				
			}
			
			//닫음
			st.close();
			
		} catch (Exception e) {
			System.out.println("드라이버 검색 실패");
			e.printStackTrace(); //에러 메세지의 발생지를 찾아 단계별로 알려주는 명령어
		}
		
	}
		

}
