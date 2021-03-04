package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.test.web.util.SessionUtil;

public class HiberTest {

	public static void main(String[] args) {
		/*
		 * 1. 아래의 정보의 테이블을 생성하세요
		 *   - table name : comput_info
		 *   - columns info
		 *    1) ci_num number pk
		 *    2) ci_code char(8) unique
		 *    3) ci_cpu varchar2(40) not null
		 *    4) ci_ram number(3,0) not null
		 *    5) ci_sdd number(7,0) 
		 *    6) ci_hdd number(8,0)
		 *    7) ci_desc varchar2(2000)
		 * 2. 위 테이블 정보와 매핑할 엔티티 클래스를 생성하세요.
		 * 3. 3개정도 로우의 가상의 데이터를 집어넣습니다.
		 *    데이터는 뭐든 상관없으며 쿼리박스에서 대충 입력해두 됩니다.
		 * 4. 지금 main 메소드안에다가 hibernate를 사용하여 list를 System.out.println으로
		 *    출력하는 코드를 작성하시면 됩니다.  
		 */
		Session ss = SessionUtil.getSession();
		Query<ComputerInfo> query = ss.createNativeQuery("select * from computer_info",ComputerInfo.class);
		List<ComputerInfo> computerInfoList = query.list();
		System.out.println(computerInfoList);
	}
}
