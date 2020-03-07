package review_action;

import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import review_svc.ReviewListService;
import vo.ActionForward;
import vo.ReviewBean;
import vo.PageInfo;
import action.Action;
import restaurant_svc.RestaurantListService;

public class ReviewSearchAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ReviewBean reviewBean = new ReviewBean();
		// searchvalues�� �ۼ��ڷ� �˻��ߴ��� �������� �˻��޴��� �� ���� �������°�
		String search = (String) request.getParameter("searchvalues");
		String keyword = (String) request.getParameter("keyword");
		ActionForward forward = new ActionForward();
		reviewBean.setSearch(search);
		reviewBean.setKeyword(keyword);
		ReviewListService reviewListService = new ReviewListService();
		ArrayList<ReviewBean> articleList = new ArrayList<ReviewBean>();

		if (search.equals("title")) {
			boolean isRightUser = reviewListService.findtitle_condition(reviewBean);
			// ���Ϲ��� ���� false�� ������� ���� true�� ���������� ���ǰ˻� ����� �����ֵ��� �ϱ����� �۾�
			if (!isRightUser) {
				request.setAttribute("false",isRightUser );	
				forward.setPath("/board1.jsp");
				return forward;

			} else {
				articleList = reviewListService.getTitleList(reviewBean);

			}
		} else {

			boolean isRightUser = reviewListService.findnick_condition(reviewBean);

			// ���Ϲ��� ���� false�� ������� ���� true�� ���������� ���ǰ˻� ����� �����ֵ��� �ϱ����� �۾�
			if (!isRightUser) {
				request.setAttribute("false",isRightUser );	
				forward.setPath("/board1.jsp");
				return forward;
			} else {
				articleList = reviewListService.getidList(reviewBean);

			}
		}

		request.setAttribute("searchList", articleList);
	
		forward.setPath("/board1.jsp");
		return forward;

	}

}