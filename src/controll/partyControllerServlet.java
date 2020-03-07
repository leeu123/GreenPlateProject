package controll; //占쏙옙占쏙옙-> url 占쏙옙占쏙옙

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class partyControllerServlet extends HttpServlet {

	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String RequestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String rung = RequestURI.substring(contextPath.length());  // url 의 주소를 받는 변수


			if (rung.equals("/partyregi.do")) {   // 파티 모집 시
				partyService service = new partyService();

				String index = service.inseParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);
			}
			else if(rung.equals("/partycate.do")) {  // 진행중인 파티 중 음식 카테고리 별 파티 추출
				partyService service = new partyService();
				String index = service.selelistParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if(rung.equals("/partyinfo.do")) {  // 식당 정보 추출
				partyService service = new partyService();
				
				String index = service.seleParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			
			else if(rung.equals("/partycatere.do")) { // 완료된 파티 중 음식 카테고리 별 파티 추출
				partyService service = new partyService();
				String index = service.selelistPartyre(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if(rung.equals("/partyinfore.do")) {  // 완료된 파티 중 음식 카테고리 별 파티 추출
				partyService service = new partyService();
				String index = service.selePartyre(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if(rung.equals("/partyapply.do")) {   // 파티 신청 시
				partyService service = new partyService();
				
				String index = service.inseApply(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if (rung.equals("/navsearch.do")) { // index에서 검색 시
				System.out.println("navsearch");
				partyService service = new partyService();
				String index = service.navsearch(request, response);
				request.getRequestDispatcher(index).forward(request, response);
			}
		
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
