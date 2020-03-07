package controll; //db占쏙옙占쏙옙占쏙옙占쏙옙 처占쏙옙 -> 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙


import java.time.LocalDate;
import java.util.ArrayList;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import party.partyAction;
import restaurant.restauAction;
import vo.DTO_AD;
import vo.PageInfo;
import party.PartyDTO;
import party.ApplyDTO;
import party.Preview;
import resdat.resdatDTO;

public class partyService implements partyCommandInter {
	static partyService impl = new partyService();

	public static partyService instance() {
		return impl;

	}

	@Override
	public String inseParty(HttpServletRequest request, HttpServletResponse response) throws Exception {  // �뙆�떚 �벑濡앺븯湲�
		try {
			PartyDTO PartyDTO = new PartyDTO();

			String realFolder = "";
			String saveFolder = "/partyUpload";
			int fileSize = 5 * 1024 * 1024;
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());
			PartyDTO.setTitle(multi.getParameter("title"));
			PartyDTO.setId(multi.getParameter("id"));
			PartyDTO.setNick(multi.getParameter("nick"));
			PartyDTO.setEmail(multi.getParameter("email"));
			PartyDTO.setPhone(multi.getParameter("phone"));
			PartyDTO.setCate(multi.getParameter("cate"));
			PartyDTO.setRname(multi.getParameter("rname"));
			PartyDTO.setRfile(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
			
			PartyDTO.setAddno(multi.getParameter("addno"));
			PartyDTO.setAddr(multi.getParameter("addr"));
			PartyDTO.setAddr1(multi.getParameter("addr1"));
			PartyDTO.setAddr2(multi.getParameter("addr2"));
			
			PartyDTO.setPdate(multi.getParameter("pdate"));
			PartyDTO.setPtime(multi.getParameter("hour")+"시"+multi.getParameter("minu")+"분");
			
			PartyDTO.setSins(LocalDate.of(Integer.parseInt("20"+multi.getParameter("pdate").substring(0, 2)), Integer.parseInt(multi.getParameter("pdate").substring(2, 4)), Integer.parseInt(multi.getParameter("pdate").substring(4, 6))).minusDays(11).toString());
			PartyDTO.setSinf(LocalDate.of(Integer.parseInt("20"+multi.getParameter("pdate").substring(0, 2)), Integer.parseInt(multi.getParameter("pdate").substring(2, 4)), Integer.parseInt(multi.getParameter("pdate").substring(4, 6))).minusDays(1).toString());
			//�엯�젰諛쏆� �뙆�떚 �궇吏쒖뿉�꽌 -11怨� -1�쓣 �븳 �썑 �뙆�떚�떊泥� �떆�옉 �궇吏쒖� 醫낅즺 �궇吏쒕�� �엯�젰
		     System.out.println();
			
			PartyDTO.setPno(multi.getParameter("pno"));
			PartyDTO.setPreprice(multi.getParameter("preprice"));
			PartyDTO.setPtalk(multi.getParameter("ptalk"));
			partyAction model = partyAction.instance();
			model.insertParty(PartyDTO);

		} catch (Exception e) {
			System.out.println(e);
		}

		return "party.jsp";
	}
	
	@Override
	public String selelistParty(HttpServletRequest request, HttpServletResponse response) throws Exception {  // 吏꾪뻾以묒씤 �뙆�떚 category 蹂꾨줈 �굹�삱 �닔 �엳�룄濡� �뙆�떚 遺덈윭�삤湲�
		try{partyAction model = partyAction.instance();
		
	    ArrayList<PartyDTO> list = (ArrayList<PartyDTO>) model.selectlistParty(request.getParameter("cate"));
		if(list.size()!=0) {request.setAttribute("list", list);
		return "partycate.jsp";}
		else {
			return "noparty.jsp";
		}
		}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
		
	}
	
	@Override
	public String seleParty(HttpServletRequest request, HttpServletResponse response) throws Exception { // �뙆�떚 踰덊샇濡� �뙆�떚 遺덈윭�삤湲� 
		try{partyAction model = partyAction.instance();
		
	    ArrayList<PartyDTO> sic = (ArrayList<PartyDTO>) model.selectParty(Integer.parseInt(request.getParameter("pnum")));
		if(sic.size()!=0) {request.setAttribute("sic", sic);
		return "party_info.jsp";}
		else {
			return "noparty.jsp";
		}}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
	}
	
	@Override
	public String selelistPartyre(HttpServletRequest request, HttpServletResponse response) throws Exception {  // �셿猷뚮맂 �뙆�떚 category 蹂꾨줈 �굹�삱 �닔 �엳�룄濡� �뙆�떚 遺덈윭�삤湲�
		try{partyAction model = partyAction.instance();
		
	    ArrayList<PartyDTO> list = (ArrayList<PartyDTO>) model.selectlistPartyre(request.getParameter("cate"));
		if(list.size()!=0) {request.setAttribute("list", list);
		return "partycatere.jsp";}
		else {
			return "noparty.jsp";
		}
		}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
		
	}
	
	@Override
	public String selePartyre(HttpServletRequest request, HttpServletResponse response) throws Exception { // �뙆�떚 踰덊샇濡� �뙆�떚 遺덈윭�삤湲� 
		try{partyAction model = partyAction.instance();
	    ArrayList<PartyDTO> sic = (ArrayList<PartyDTO>) model.selectPartyre(Integer.parseInt(request.getParameter("pnum")));
		if(sic.size()!=0) {request.setAttribute("sic", sic);
		return "party_infore.jsp";}
		else {
			return "noparty.jsp";
		}}
		catch(Exception e) {
			System.out.println(e);
			return "noparty.jsp";
		}
	}
	
	@Override
	public boolean insePreview(HttpServletRequest request, HttpServletResponse response) throws Exception { //�셿猷뚮맂 �뙆�떚 踰덊샇 蹂꾨줈 �뙎湲� �떖湲�
		try {
			Preview Preview = new Preview();
            Preview.setPnum(Integer.parseInt(request.getParameter("pnum")));
            Preview.setId(request.getParameter("id"));
            Preview.setNick(request.getParameter("nick"));
            Preview.setRcontent(request.getParameter("rcontent"));
            
            
            System.out.println(request.getParameter("pnum"));
            System.out.println(request.getParameter("id"));
            System.out.println(request.getParameter("nick"));
            System.out.println(request.getParameter("rcontent"));
            
			partyAction model = partyAction.instance();
			model.insertPreview(Preview);

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	@Override
	public ArrayList<Preview> selelistPreview(HttpServletRequest request, HttpServletResponse response){  // �뙆�떚 �썑湲� �뙎湲� 遺덈윭�삤湲�
		try{partyAction model = partyAction.instance();
	    ArrayList<Preview> list = (ArrayList<Preview>) model.selectlistPreview(Integer.parseInt(request.getParameter("pnum")));
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public String inseApply(HttpServletRequest request, HttpServletResponse response) throws Exception {  // �뙆�떚 �떊泥� �젙蹂� �엯�젰
		try {
			ApplyDTO ApplyDTO = new ApplyDTO();
			ApplyDTO.setPnum(Integer.parseInt(request.getParameter("pnum")));
			ApplyDTO.setId(request.getParameter("id"));
			partyAction model = partyAction.instance();
			model.insertApply(ApplyDTO);
			

		} catch (Exception e) {
			System.out.println(e);
		}

		return "apply_success.jsp";
	}
	
	@Override
	public boolean seleApply(HttpServletRequest request, HttpServletResponse response){ // �씠誘� �떊泥��븳 �뙆�떚�씤吏� �솗�씤�븯�뒗 硫붿냼�뱶
		try{
			ApplyDTO adto = new ApplyDTO();
			adto.setPnum(Integer.parseInt(request.getParameter("pnum")));
			adto.setId(request.getParameter("id"));
			partyAction model = partyAction.instance();
	        boolean tf = model.selectApply(adto);
	    if(tf) {
	    return true;
	    }
	    else {
	    	return false;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	
	@Override
	public ArrayList<resdatDTO> selelistmasjip(HttpServletRequest request, HttpServletResponse response){  // �룊�젏 �닚 踰좎뒪�듃 10 �떇�떦源뚯� 怨좊Ⅴ�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<resdatDTO> list = (ArrayList<resdatDTO>)model.selectlistmasjip();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public ArrayList<resdatDTO> selelistmasjipkor(HttpServletRequest request, HttpServletResponse response){  // �븳�떇 �룊�젏 �닚 踰좎뒪�듃 10 怨좊Ⅴ�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<resdatDTO> list = (ArrayList<resdatDTO>)model.selectlistmasjipkor();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public ArrayList<resdatDTO> selelistmasjipchn(HttpServletRequest request, HttpServletResponse response){  // 以묒떇 �룊�젏 �닚 踰좎뒪�듃 10 怨좊Ⅴ�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<resdatDTO> list = (ArrayList<resdatDTO>)model.selectlistmasjipchn();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public ArrayList<resdatDTO> selelistmasjipjpn(HttpServletRequest request, HttpServletResponse response){  // �씪�떇 �룊�젏 �닚 踰좎뒪�듃 10 怨좊Ⅴ�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<resdatDTO> list = (ArrayList<resdatDTO>)model.selectlistmasjipjpn();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public ArrayList<resdatDTO> selelistmasjipwest(HttpServletRequest request, HttpServletResponse response){  // �뼇�떇 �룊�젏 �닚 踰좎뒪�듃 10 怨좊Ⅴ�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<resdatDTO> list = (ArrayList<resdatDTO>)model.selectlistmasjipwest();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public ArrayList<resdatDTO> selelistmasjipwhat(HttpServletRequest request, HttpServletResponse response){  // �꽭怨꾩쓬�떇 �룊�젏 �닚 踰좎뒪�듃 10 怨좊Ⅴ�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<resdatDTO> list = (ArrayList<resdatDTO>)model.selectlistmasjipwhat();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public ArrayList<resdatDTO> selelistmasjipworld(HttpServletRequest request, HttpServletResponse response){  // 以묒떇 �룊�젏 �닚 踰좎뒪�듃 10 怨좊Ⅴ�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<resdatDTO> list = (ArrayList<resdatDTO>)model.selectlistmasjipworld();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	
	
	@Override
	public DTO_AD seleRestau(HttpServletRequest request, HttpServletResponse response){ // �룊�젏�닚 �떇�떦踰덊샇�뿉 留욌뒗 �떇�떦�젙蹂� 李얠븘�삤�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance();
	    DTO_AD list = (DTO_AD)model.selectRestau(Integer.parseInt(request.getAttribute("rnum").toString()));
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	
	@Override
	public resdatDTO seleResdat(HttpServletRequest request, HttpServletResponse response){ // �룊�젏�닚 �떇�떦踰덊샇�뿉 留욌뒗 �떇�떦�젙蹂� 李얠븘�삤�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance();
	    resdatDTO list = (resdatDTO)model.selectResdat(Integer.parseInt(request.getAttribute("rnum").toString()));
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	
	@Override
	public int seleApplycount(HttpServletRequest request, HttpServletResponse response){ //�쁽�옱 �떊泥�紐낆닔 戮묒븘�삤湲�
		try{
			partyAction model = partyAction.instance();
	        int Apply_count = model.selectApplycount(Integer.parseInt(request.getAttribute("pnum").toString()));
	    if(Apply_count!=0) {
	    return Apply_count;
	    }
	    else {
	    	return 0;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}
	
	@Override
	public boolean Applyable(HttpServletRequest request, HttpServletResponse response){  // �뙆�떚�떊泥�湲곌컙�뿉 留욌뒗吏� �솗�씤�븯�뒗 硫붿냼�뱶
		try{
			partyAction model = partyAction.instance();
			System.out.println(request.getAttribute("pnum"));
	        boolean applyable = model.Applyable(Integer.parseInt(request.getAttribute("pnum").toString()));
	    if(applyable) {
	    return true;
	    }

		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	@Override
	public ArrayList<DTO_AD> seleViewtop(HttpServletRequest request, HttpServletResponse response){  // 議고쉶�닔 �닚 top 10 戮묒븘�궡�뒗 硫붿냼�뱶
		try{restauAction model = restauAction.instance(); 
	    ArrayList<DTO_AD> list = (ArrayList<DTO_AD>)model.selectViewtop();
	    if(list != null) {
	    return list;
	    }
	    else {
	    	return null;
	    }
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public String navsearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("navsearch�떆�옉");
		request.setCharacterEncoding("UTF-8");
        String [] navloca = request.getParameterValues("location");
        String [] navtype = request.getParameterValues("type");
        String [] navprice = request.getParameterValues("price");
        
        
       DTO_AD dtoad = new DTO_AD();
       dtoad.setNavloca(navloca);
       dtoad.setNavtype(navtype);
       dtoad.setNavprice(navprice);
    
       
       int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		restauAction model = restauAction.instance();
		ArrayList<DTO_AD> list = (ArrayList<DTO_AD>) model.navsearch(dtoad);
		int listCount=list.size();
		System.out.println(listCount);
       
		int maxPage=(int)((double)listCount/limit+0.95); 
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   	        int endPage = startPage+10-1;

   	        
   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		
		
		
	    if(list.size()!=0) {
		request.setAttribute("articleList", list);
		System.out.println("bb" + list.size());
		System.out.println("navsearch�걹");
		return "searchpage.jsp";
		}
	    else {
			return "nosearch.jsp";
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
