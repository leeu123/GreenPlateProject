package restaurantDAO;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.DTO_AD;

public class RestaurantDAO {

	DataSource ds;
	Connection con;
	private static RestaurantDAO RestaurantDAO;

	private RestaurantDAO() {
		// TODO Auto-generated constructor stub
	}

	public static RestaurantDAO getInstance(){
		if(RestaurantDAO == null){
			RestaurantDAO = new RestaurantDAO();
		}
		return RestaurantDAO;
	}

	public  void  setConnection(Connection con){
		this.con = con;
	}

	//조검 검색에 해당하는 게시물이 몇개있는지 
	public int selectListCount(DTO_AD dto) {
          System.out.println("selectListCount"+dto.getLocation());
		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=con.prepareStatement("select count(*) from restaurant where type=? and price = ? and home like '%"+dto.getLocation()+"%'");
			pstmt.setString(1, dto.getType());
			pstmt.setString(2, dto.getPrice());
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){

		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	//조건검색에 해당하는 정보를 가져오는 작업	
	public ArrayList<DTO_AD> selectArticleList(int page,int limit,DTO_AD dto){
        System.out.println("3번 select");
        System.out.println("selectArticleList"+page+"limut="+limit+"dto="+dto.getLocation());
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from restaurant where type=? and price = ? and home like '%"+dto.getLocation()+"%' limit ?,10";
		ArrayList<DTO_AD> articleList = new ArrayList<DTO_AD>();
		DTO_AD board = null;
		int startrow=(page-1)*10;
	
		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setString(1, dto.getType());
			pstmt.setString(2, dto.getPrice());
					
			pstmt.setInt(3, startrow);
		
			rs = pstmt.executeQuery();
            
			while(rs.next()){
				
				board = new DTO_AD();
				board.setRnum(rs.getInt("rnum"));
				board.setName(rs.getString("name"));
				board.setCell(rs.getString("cell"));
				board.setEmail(rs.getString("email"));
				board.setType(rs.getString("type"));
				board.setStore(rs.getString("store"));
				board.setPrice(rs.getString("price"));
				board.setHome(rs.getString("home"));
				board.setDethome(rs.getString("dethome"));
				board.setFile(rs.getString("file"));
				board.setReadcount(rs.getInt("readcount"));
				
				
				System.out.println("select으로 가져온 readcount"+rs.getInt("readcount"));
				articleList.add(board);
			}
			
			

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	//조건 검색 결과 없을 경우 경고문구 보내기 위한 작업
	public boolean findcondition(DTO_AD dto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("dao에서 확인"+dto.getPrice()+dto.getType()+dto.getLocation());
		String board_sql = "select type,price,home from restaurant where type=? and price = ? and home like '%"+dto.getLocation()+"%'";
		boolean isWriter = false;

		try {
			pstmt = con.prepareStatement(board_sql);
			pstmt.setString(1, dto.getType());
			pstmt.setString(2, dto.getPrice());
			rs = pstmt.executeQuery();
			rs.next();
			{
	           if(rs.getString("home").contains(dto.getLocation())&&dto.getPrice().equals(rs.getString("price"))&&dto.getType().equals(rs.getString("type"))) {
				isWriter = true;
	           }
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			close(pstmt);
		}

		return isWriter;

	}
	


	//선택한 식당 정보를 자세히 보여주는 작업
	public DTO_AD selectArticle(int rnum){
		System.out.println("4번");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_AD dto = null;

		try{
			System.out.println("5번");
			pstmt = con.prepareStatement(
					"select * from restaurant where rnum = ?");
			pstmt.setInt(1, rnum);
			rs= pstmt.executeQuery();
			if(rs.next()){
				System.out.println("if문 작동");
				dto = new DTO_AD();
				dto.setRnum(rs.getInt("rnum"));
				dto.setName(rs.getString("name"));
				dto.setCell(rs.getString("cell"));
				dto.setEmail(rs.getString("email"));
				dto.setType(rs.getString("type"));
				dto.setStore(rs.getString("store"));
				dto.setPrice(rs.getString("price"));
				dto.setHome(rs.getString("home"));
				dto.setContent(rs.getString("content"));
				dto.setPostnum(rs.getString("postnum"));
				dto.setFile(rs.getString("file"));
				dto.setDethome(rs.getString("dethome"));
				dto.setParking(rs.getString("parking"));
				dto.setStart_time(rs.getString("start_time"));
				dto.setFinish_time(rs.getString("finish_time"));
				dto.setBreak_time(rs.getString("break_time"));
			}
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return dto;

	}

	//�뜝�룞�삕 �뜝�룞�삕�뜝占�.
	public int insertArticle(DTO_AD article){
		
        System.out.println("식당등록dao작동");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;

		try{
			pstmt=con.prepareStatement("select max(rnum) from restaurant");
			rs = pstmt.executeQuery();
		
			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;

			sql="insert into restaurant (id,name,cell,email,type,store,price,home,content,postnum,file,dethome,readcount,parking,start_time,finish_time,break_time,location) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("dfsdf");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getId());
			pstmt.setString(2, article.getName());
			pstmt.setString(3, article.getCell());
			pstmt.setString(4, article.getEmail());
			pstmt.setString(5, article.getType());
			pstmt.setString(6, article.getStore());
			pstmt.setString(7, article.getPrice());
			pstmt.setString(8, article.getHome());
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getPostnum());
			pstmt.setString(11, article.getFile());
			pstmt.setString(12, article.getDethome());
			pstmt.setInt(13, 0);
			pstmt.setString(14, article.getParking());
			pstmt.setString(15, article.getStart_time());
			pstmt.setString(16, article.getFinish_time());
			pstmt.setString(17, article.getBreak_time());
			pstmt.setString(18, article.getLocation());
			

			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}


	//리뷰 값 올려주기
	public int updateReadCount(int rnum){
       
         System.out.println("3번");  
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update restaurant set readcount = "+
				"readcount+1 where rnum = "+rnum;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally{
			close(pstmt);

		}

		return updateCount;

	}

	
	

}
