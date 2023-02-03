package edu.kh.jdbc.run;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run {

	public static void main(String[] args) {
		
		TestService service = new TestService();
		
		// 원리원칙은 RUN에서 실행메서드 하나만 돌아가야함
		
		// TB_TEST 테이블에 INSERT 수행
		TestVO vo1 = new TestVO(1, "제목1", "내용1"); // 서비스에 넘겨서 INSERT할 수 있게 하고싶으면?
		
		// TB_TEST 테이블에 insert를 수행하는 서비스 메서드를
		// 호출 후 결과 반환 받기
		
		try {
			int result = service.insert(vo1); // 1/0 = 성공/실패
			
			if(result > 0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
		} catch(Exception e) {
			System.out.println("SQL 수행 중 오류 발생");
		}
	}
}	

// 순서
// 1. CreateXMLFile
// 2. driver.xml
// 3. LoadXMLFile
// 4. JDBCTemplate
// 5. Run / TestService / TestDAO / TestVO