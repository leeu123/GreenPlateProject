package controll; //����-> url ����

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
			String rung = RequestURI.substring(contextPath.length());  // url �� �ּҸ� �޴� ����


			if (rung.equals("/partyregi.do")) {   // ��Ƽ ���� ��
				partyService service = new partyService();

				String index = service.inseParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);
			}
			else if(rung.equals("/partycate.do")) {  // �������� ��Ƽ �� ���� ī�װ� �� ��Ƽ ����
				partyService service = new partyService();
				String index = service.selelistParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if(rung.equals("/partyinfo.do")) {  // �Ĵ� ���� ����
				partyService service = new partyService();
				
				String index = service.seleParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			
			else if(rung.equals("/partycatere.do")) { // �Ϸ�� ��Ƽ �� ���� ī�װ� �� ��Ƽ ����
				partyService service = new partyService();
				String index = service.selelistPartyre(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if(rung.equals("/partyinfore.do")) {  // �Ϸ�� ��Ƽ �� ���� ī�װ� �� ��Ƽ ����
				partyService service = new partyService();
				String index = service.selePartyre(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if(rung.equals("/partyapply.do")) {   // ��Ƽ ��û ��
				partyService service = new partyService();
				
				String index = service.inseApply(request, response);
				request.getRequestDispatcher(index).forward(request, response);
				
			}
			else if (rung.equals("/navsearch.do")) { // index���� �˻� ��
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
