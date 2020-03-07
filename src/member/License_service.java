package member;

import static db.JdbcUtil.*;
import java.sql.Connection;
import member.License_DAO;
import model.LicenseDTO;
import review_dao.ReviewDAO;
import vo.ReviewBean;

public class License_service {
//����� ���̺� ���޹��� ���̵� �ִ��� Ȯ���ϱ����� License_DAO�������� �����ִ� ������
	public boolean isArticleWriter(String id) throws Exception {
		boolean isArticleWriter = false;
		Connection con = getConnection();
		License_DAO reviewDAO = License_DAO.getInstance();
		reviewDAO.setConnection(con);
		isArticleWriter = reviewDAO.isArticleBoardWriter(id);
		close(con);
		return isArticleWriter;

	}
	
	public boolean insert(LicenseDTO dto) throws Exception{
        
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		License_DAO licenseDAO = License_DAO.getInstance();
	    licenseDAO.setConnection(con);
		int insertCount = licenseDAO.insertArticle(dto);
		if(insertCount > 0){
			commit(con);
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}

}
