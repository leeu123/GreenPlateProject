package review_svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import restaurantDAO.RestaurantDAO;
import review_dao.ReviewDAO;
import vo.DTO_AD;
import vo.ReviewBean;

public class ReviewListService {

	public int getListCount() throws Exception{
		
		int listCount = 0;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		listCount = reviewDAO.selectListCount();
		System.out.println("1번 리스트카운트 작동"+listCount);
		close(con);
		return listCount;
		
	}

public ArrayList<ReviewBean> getLocalList(String local) throws Exception{
	System.out.println("service문 작동");
	ArrayList<ReviewBean> articleList = null;
	Connection con = getConnection();
	ReviewDAO reviewDAO = ReviewDAO.getInstance();
	reviewDAO.setConnection(con);
	articleList = reviewDAO.selectLocalList(local);
	System.out.println("articleList리턴받은지 확인="+articleList.get(0).getLocation());
	close(con);
	return articleList;
	
}
public boolean findcondition(String local) throws Exception {
	System.out.println("2번findcondition작동");
	boolean findResult = false;
	Connection con = getConnection();
	ReviewDAO reviewDAO = ReviewDAO.getInstance();
	reviewDAO.setConnection(con);
	findResult = reviewDAO.findcondition(local);
	System.out.println("4번 dao에서 리턴받은값"+findResult);
	close(con);
	return findResult;

}
//리뷰게시판에서 제목으로 게시물 검색 했을경우 조건에 맞는 게시물이 있는지 확인하기 위해서
public boolean findtitle_condition(ReviewBean dto) throws Exception {
	boolean findResult = false;
	Connection con = getConnection();
	ReviewDAO reviewDAO = ReviewDAO.getInstance();
	reviewDAO.setConnection(con);
	findResult = reviewDAO.findtitle_condition(dto);
	close(con);
	return findResult;

}
//리뷰게시판에서 작성자로 게시물을 검색 했을경우 조건에 맞는 게시물이 있는지 확인하기 위해서
public boolean findnick_condition(ReviewBean dto) throws Exception {
	boolean findResult = false;
	Connection con = getConnection();
	ReviewDAO reviewDAO = ReviewDAO.getInstance();
	reviewDAO.setConnection(con);
	findResult = reviewDAO.findnick_condition(dto);
	close(con);
	return findResult;

}

	public ArrayList<ReviewBean> getArticleList(int page, int limit) throws Exception{
		System.out.println("전체출력문 메소드 작동");
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectArticleList(page,limit);
		
		close(con);
		return articleList;
		
	}
	public ArrayList<ReviewBean> getTitleList( ReviewBean reviewbean) throws Exception{
		System.out.println("gettitlelist 확인");
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectTitleList(reviewbean);
		System.out.println("메소드에서 리턴받은값 확인="+articleList.get(0).getRtitle());
		close(con);
		return articleList;
		
	}
public ArrayList<ReviewBean> getidList(ReviewBean reviewbean) throws Exception{
		
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectIdList(reviewbean);
		
		close(con);
		return articleList;
		
	}

}
