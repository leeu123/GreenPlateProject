package restaurant_action;

import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant_svc.RestaurantListService;
import vo.ActionForward;
import vo.DTO_AD;
import vo.PageInfo;
import action.Action;

 public class RestaurantListAction implements Action {
	  
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 ActionForward forward= new ActionForward();
	
        DTO_AD dto = new DTO_AD();
        dto.setPrice(request.getParameter("price"));
        dto.setType(request.getParameter("type"));
        dto.setLocation(request.getParameter("location"));
		ArrayList<DTO_AD> articleList=new ArrayList<DTO_AD>();
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		
		RestaurantListService restaurantListService = new RestaurantListService();
		boolean isRightUser = restaurantListService.findcondition(dto);
		
		//���Ϲ��� ���� false�� ������� ���� true�� ���������� ���ǰ˻� ����� �����ֵ��� �ϱ����� �۾�
		if (!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�˻������ �����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
		int listCount=restaurantListService.getListCount(dto);
	
			articleList = restaurantListService.getArticleList(page,limit,dto);
			System.out.println(articleList.get(0).getReadcount());
		//�� ������ ��.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
   		forward.setPath("/searchpage.jsp");
   		
		}return forward;
	 }
	 
 }