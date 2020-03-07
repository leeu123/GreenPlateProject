package review_svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.ReviewBean;
import review_dao.ReviewDAO;

public class ReviewModifyProService {
//��� ������ִ� ��й�ȣ�� �Խñ� ���� �ڰ� �Է��� ��й�ȣ�� �������� Ȯ���ϱ� ���� �۾�
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
	     System.out.println("2��");
		boolean isArticleWriter = false;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		isArticleWriter = reviewDAO.isArticleBoardWriter(board_num, pass);
		System.out.println("����Ȯ��"+isArticleWriter);
		close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(ReviewBean article) throws Exception {
	     System.out.println("5��");
		boolean isModifySuccess = false;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		int updateCount = reviewDAO.updateArticle(article);
		
		if(updateCount > 0){
			commit(con);
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}

}
