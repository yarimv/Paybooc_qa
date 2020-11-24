package eleven.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logtest {
	
	static final Logger log = LogManager.getLogger(logtest.class);
	
	public static void main () {
		log.info("로그테스트"); //이 다음에 스프링부트가 나와서 일단 작성 종료....
		
	}

}
