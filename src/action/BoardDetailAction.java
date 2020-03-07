package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;


 public class BoardDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	System.out.println("BoardDetailAction 작동");
	   	ActionForward forward = new ActionForward();
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		if(request.getParameter("id").equals("id")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요.');");
			out.println("history.back();");
			out.println("</script>");
			
		}else
		{	
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		System.out.println(article.getQnum());
		
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
   		forward.setPath("/qna_boardview.jsp");
   		
		}return forward;
	 }
	 
}