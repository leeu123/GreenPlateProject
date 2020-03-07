package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardReplyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyProAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
	         System.out.println("�亯�޸� 1��°");
		  
		 	ActionForward forward = null;
		    String nowPage = request.getParameter("page");
		 	BoardBean article = new BoardBean();  		
		 	article.setQnum(Integer.parseInt(request.getParameter("qnum")));
		 	article.setNick(request.getParameter("nick"));
		 	article.setQpass(request.getParameter("qpass"));
		 	article.setQtitle(request.getParameter("qtitle"));
		 	article.setQcontent(request.getParameter("qcontent"));
		 	article.setQref(Integer.parseInt(request.getParameter("qref")));
		 	article.setQlev(Integer.parseInt(request.getParameter("qlev")));
		 	article.setQseq(Integer.parseInt(request.getParameter("qseq")));	   		
		 	BoardReplyProService boardReplyProService = new BoardReplyProService();
		 	boolean isReplySuccess = boardReplyProService.replyArticle(article);
		 	
	   		if(isReplySuccess){
	   			System.out.println("isReplySuccess �۵�");
	   			forward = new ActionForward();
	   			forward.setRedirect(true);
	   			forward.setPath("boardList.bo?page=" + nowPage);
	   		}
	   		else{
	   			response.setContentType("text/html;charset=UTF-8");
	   			PrintWriter out = response.getWriter();
	   			out.println("<script>");
	   			out.println("alert('�������')");
	   			out.println("history.back()");
	   			out.println("</script>");
	   		}
	   		
	   		return forward;
	   		
	}  	
	 
}