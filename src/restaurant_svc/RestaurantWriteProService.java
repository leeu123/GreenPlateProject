package restaurant_svc;

import java.sql.Connection;
import restaurantDAO.RestaurantDAO;
import vo.DTO_AD;
import static db.JdbcUtil.*;
public class RestaurantWriteProService {

	public boolean registArticle(DTO_AD boardBean) throws Exception{

		System.out.println("�Ĵ���service�۵�");
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		RestaurantDAO reviewDAO = RestaurantDAO.getInstance();
		reviewDAO.setConnection(con);
		int insertCount = reviewDAO.insertArticle(boardBean);
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
