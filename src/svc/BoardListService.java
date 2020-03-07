package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.BoardDAO;

import vo.BoardBean;


public class BoardListService {

	public int getListCount() throws Exception{
		System.out.println("boardlistservie getlistcount()�޼ҵ� ����");
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		System.out.println("���ϰ�"+listCount);
		close(con);
		return listCount;
		
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception{
		System.out.println("getArticleList �۵�");
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page,limit);
		System.out.println(articleList.size());
		close(con);
		return articleList;
		
	}
	public ArrayList<BoardBean> getTitleList(BoardBean boardbean) throws Exception{
		System.out.println("gettitlelist Ȯ��");
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO reviewDAO = BoardDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectTitleList(boardbean);
		
		close(con);
		return articleList;
		
	}
public ArrayList<BoardBean> getidList(BoardBean reviewbean) throws Exception{
		
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO reviewDAO = BoardDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectIdList(reviewbean);
		
		close(con);
		return articleList;
		
	}

}
