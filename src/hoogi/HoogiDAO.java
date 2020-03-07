package hoogi;

import java.sql.*;
import java.util.ArrayList;

public class HoogiDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/gpteam?useSSL=false&useUnicode=true&characterEncoding=utf8";

	private final String USER_NAME = "root";
	private final String PASSWORD = "12345";

	Connection conn = null;
	Statement state = null;

	public HoogiDAO() {  // DB 占쎈굶占쎈선揶쏉옙占쎈뮉 筌롫뗄�꺖占쎈굡
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("占쎌궎�몴�꼵占� 占쎈선占쎈선占쎌뒄");
		}

	}

	public void entdb() { // DB 占쎈굶占쎈선揶쏉옙占쎈뮉 筌롫뗄�꺖占쎈굡

		try {
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("占쎌궎�몴�꼵占� 占쎈선占쎈선占쎌뒄");

		}
	}

	public String getDate() {  // DB占쎈퓠占쎄퐣 占쎄텊筌욑옙 

		String in = null;

		try {
			state = conn.createStatement(); //
			String s = "select now()";
			ResultSet aa = state.executeQuery(s);
			if (aa.next()) {
				return aa.getString(1);
			}
		} catch (Exception e) {
		}

		return in;
	}

	public int getpNum() {

		try {
			state = conn.createStatement(); //
			String s = "select rpostnum from preview order by rpostnum desc"; // 占쎌젫占쎌뵬 占쎌맄占쎈퓠 占쎌뿳占쎈뮉 占쎈７占쎈뮞占쎈뱜占쎄퐜(野껊슣�뻻�눧占� 甕곕뜇�깈) 占쎈떭占쎌쁽 揶쏉옙占쎌죬占쎌긾
			ResultSet aa = state.executeQuery(s);
			if (aa.next()) {
				return aa.getInt(1) + 1;
			}
			return 1; // 筌ｃ꺂苡뀐옙�삺 占쎌뵥 野껋럩�뒭
		} catch (Exception e) {
		}

		return -1;
	}

	public int write(String rtitle, String nick, String rcontent) {
		try {
			state = conn.createStatement(); //
			String s = "insert into preview(rpostnum,rname,rtitle,nick,rcontent,date,available) values(" + getpNum() + ",'占쎈뻼占쎈뼣占쎌뵠�뵳占�','" + rtitle
					+ "','" + nick + "','" + rcontent + "','" + getDate() + "',1);";
			state.executeUpdate(s);
			return 0; // 占쎌뿯占쎌젾占쎈쭍占쎈르
		} catch (Exception e) {
			System.out.println("占쎌뵠占쎄맒占쎌뵠 占쎌뿳");
		}
		return -1; // 占쎌궎�몴�꼵占� 獄쏆뮇源�占쎈뻥占쎌뱽 占쎈르
	}

	public ArrayList<Hoogi> getList(int pagenumber) {
		entdb();
		ArrayList<Hoogi> hl = new ArrayList<Hoogi>();
		try {
			state = conn.createStatement(); //
			String s = "select * from preview where rpostnum < '" + (getpNum()-(pagenumber-1)*15) + "' order by rpostnum desc limit 15;";
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				Hoogi hoo = new Hoogi();				
				hoo.setRpostnum(aa.getInt("rpostnum"));
				hoo.setRtitle(aa.getString("rtitle"));
				hoo.setRname(aa.getString("rname"));
				hoo.setNick(aa.getString("nick"));
				hoo.setRcontent(aa.getString("rcontent"));
				hoo.setDate(aa.getString("date"));
				hoo.setAvailable(aa.getInt("available"));
				hl.add(hoo);
			}
		} catch (Exception e) {
			System.out.println("占쎌뵠占쎄맒占쎌뵠 占쎌뿳3");
		}

		return hl;
	}
	
	
	
	public Hoogi getBoard(String postnum) {
		entdb();
		try {
			state = conn.createStatement();
			String s = "select * from preview where rpostnum = " + postnum + ";";
			ResultSet aa = state.executeQuery(s);
			Hoogi hoo = new Hoogi();
			if(aa.next()) {
				hoo.setRpostnum(aa.getInt("rpostnum"));
				hoo.setRtitle(aa.getString("rtitle"));
				hoo.setRname(aa.getString("rname"));
				hoo.setNick(aa.getString("nick"));
				hoo.setRcontent(aa.getString("rcontent"));
				hoo.setDate(aa.getString("date"));
			}
			return hoo;
		} catch (Exception e) {
			System.out.println("占쎌뵠占쎄맒占쎌뵠 占쎌뿳14124");
		}
		return null;
	}

	public boolean nextPage(int pagenumber) {
		try {
			state = conn.createStatement(); //
			String s = "select * from preview where rpostnum < '" + getpNum() + "' order by rpostnum desc limit "
					+ (getpNum() - (pagenumber - 1) * 10) + ";";
			ResultSet aa = state.executeQuery(s);
			if (aa.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("占쎌뵠占쎄맒占쎌뵠 占쎌뿳2");
		}

		return false;
	}

	public void clodb() {
		if (state != null) {
			try {
				state.close();
			} catch (Exception e) {
				System.out.println("state 占쎈솁占쎌뵬占쎈퓠 占쎌뵠占쎄맒占쎌뵠 占쎌뿳占쎈뮸占쎈빍占쎈뼄.");
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("conn 占쎈솁占쎌뵬 占쎈뼍疫뀐옙 占쎌뵠占쎄맒占쎌뵠 占쎌뿳占쎈뮸占쎈빍占쎈뼄.");
			}

		}
	}

}
