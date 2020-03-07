package resdat;

import java.sql.*;
import java.util.ArrayList;

import resdat.resdatDTO;

public class resdatDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/gpteam?useSSL=false&useUnicode=true&characterEncoding=utf8";

	private final String USER_NAME = "root";
	private final String PASSWORD = "12345";

	Connection conn = null;
	Statement state = null;

	public resdatDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("연결에 오류가 있습니다. DAO");
		}

	}

	public void entdb() {

		try {
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("연결에 오류가 있습니다. ent");

		}
	}



	public int write(int pyung, String id, int rnum, String nick, String dcontent) { // 값을 받아서 DB에 값을 넣는 메소드
		try {
			state = conn.createStatement(); //
			String s = "insert into resdat(rnum, id,nick,pyung,dcontent,date) values('"+ rnum+"','"+ id + "','"+ nick
					+ "','" + pyung + "','" + dcontent + "',now());";
			state.executeUpdate(s);
			return 0; // 입력의 오류가 없으면 0을 반환하여라
		} catch (Exception e) {
			System.out.println("댓글 입력에 오류가 있습니다.1");
			System.out.println(e);
			return -1; // 오류가 생긴다면 -1을 반환하여라
		}
		 
	}

	public ArrayList<resdatDTO> getList(int rnum) { //식당 번호에 맞는 댓글 추출
		entdb();
		ArrayList<resdatDTO> hl = new ArrayList<resdatDTO>();
		try {
			state = conn.createStatement(); //
			String s = "select * from resdat where rnum = "+ rnum +" order by dnum desc limit 14;";
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				resdatDTO rdto = new resdatDTO();
				rdto.setDnum(aa.getInt("dnum"));
				rdto.setId(aa.getString("id"));
				rdto.setNick(aa.getString("nick"));
				rdto.setPyung(Integer.parseInt(aa.getString("pyung")));
				rdto.setDcontent(aa.getString("dcontent"));
				rdto.setDate(aa.getString("date"));
				
				hl.add(rdto);
			}
		} catch (Exception e) {
			System.out.println("댓글 추출에 오류가 있습니다.3");
			System.out.println(e);
		}

		return hl;
	}

	public ArrayList<resdatDTO> getListP(String pyung , int rnum) { // 평점과 식당번호에 맞는 댓글 추출
		entdb();
		ArrayList<resdatDTO> hl = new ArrayList<resdatDTO>();
		try {
			state = conn.createStatement(); //
			String s = "select * from resdat where pyung = '" + pyung + "' and rnum = "+ rnum +" order by dnum desc limit 14;";
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				resdatDTO rdto = new resdatDTO();
				rdto.setDnum(aa.getInt("dnum"));
				rdto.setNick(aa.getString("nick"));
				rdto.setPyung(Integer.parseInt(aa.getString("pyung")));
				rdto.setDcontent(aa.getString("dcontent"));
				rdto.setDate(aa.getString("date"));
				
				hl.add(rdto);
			}
		} catch (Exception e) {
			System.out.println("평점과 식당번호에 맞는 댓글 추출에 오류가 있습니다.");
			System.out.println(e);
		}

		return hl;
	}
	
	public double getPyung(int rnum) { // 식당 번호에 맞는 식당의 평점의 평균 추출
		entdb();
		double avg_pyung = 0;
		try {
			state = conn.createStatement(); //
			String s = "select avg(pyung) from resdat where rnum = " + rnum +";";
		    ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				avg_pyung = aa.getDouble("avg(pyung)");
			}
		} catch (Exception e) {
			System.out.println("평점의 평균을 추출하는데 오류가 있습니다.");
			System.out.println(e);
		}

		return avg_pyung;
	}

	public void clodb() {
		if (state != null) {
			try {
				state.close();
			} catch (Exception e) {
				System.out.println("state 종료 오류.");
				System.out.println(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("conn 종료 오류.");
				System.out.println(e);
			}

		}
	}

}
