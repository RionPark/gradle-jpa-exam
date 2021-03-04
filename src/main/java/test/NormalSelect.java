package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.test.web.entity.HiberInfo;
import com.test.web.util.SessionUtil;

public class NormalSelect {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","jtest","ezen1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from hiber_info");
			List<HiberInfo> hiberInfoList = new ArrayList<>();
			while(rs.next()) {
				HiberInfo hiber = new HiberInfo();
				hiber.setHiId(rs.getString("hi_name"));
				hiber.setHiName(rs.getString("hi_id"));
				hiber.setHiNum(rs.getInt("hi_id"));
				hiberInfoList.add(hiber);
			}
			System.out.println(hiberInfoList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Session ss = SessionUtil.getSession();
		Query<HiberInfo> query = ss.createNamedQuery("select * from hiber_info",HiberInfo.class);
		List<HiberInfo> list = query.list();
		System.out.println(list);
	}
}
