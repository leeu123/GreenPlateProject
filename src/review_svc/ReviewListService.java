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
		System.out.println("1�� ����Ʈī��Ʈ �۵�"+listCount);
		close(con);
		return listCount;
		
	}

public ArrayList<ReviewBean> getLocalList(String local) throws Exception{
	System.out.println("service�� �۵�");
	ArrayList<ReviewBean> articleList = null;
	Connection con = getConnection();
	ReviewDAO reviewDAO = ReviewDAO.getInstance();
	reviewDAO.setConnection(con);
	articleList = reviewDAO.selectLocalList(local);
	System.out.println("articleList���Ϲ����� Ȯ��="+articleList.get(0).getLocation());
	close(con);
	return articleList;
	
}
public boolean findcondition(String local) throws Exception {
	System.out.println("2��findcondition�۵�");
	boolean findResult = false;
	Connection con = getConnection();
	ReviewDAO reviewDAO = ReviewDAO.getInstance();
	reviewDAO.setConnection(con);
	findResult = reviewDAO.findcondition(local);
	System.out.println("4�� dao���� ���Ϲ�����"+findResult);
	close(con);
	return findResult;

}
//����Խ��ǿ��� �������� �Խù� �˻� ������� ���ǿ� �´� �Խù��� �ִ��� Ȯ���ϱ� ���ؼ�
public boolean findtitle_condition(ReviewBean dto) throws Exception {
	boolean findResult = false;
	Connection con = getConnection();
	ReviewDAO reviewDAO = ReviewDAO.getInstance();
	reviewDAO.setConnection(con);
	findResult = reviewDAO.findtitle_condition(dto);
	close(con);
	return findResult;

}
//����Խ��ǿ��� �ۼ��ڷ� �Խù��� �˻� ������� ���ǿ� �´� �Խù��� �ִ��� Ȯ���ϱ� ���ؼ�
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
		System.out.println("��ü��¹� �޼ҵ� �۵�");
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectArticleList(page,limit);
		
		close(con);
		return articleList;
		
	}
	public ArrayList<ReviewBean> getTitleList( ReviewBean reviewbean) throws Exception{
		System.out.println("gettitlelist Ȯ��");
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectTitleList(reviewbean);
		System.out.println("�޼ҵ忡�� ���Ϲ����� Ȯ��="+articleList.get(0).getRtitle());
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
