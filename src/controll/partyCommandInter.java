package controll; //�������̽�

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import party.Preview;
import resdat.*;
import vo.*;

public interface partyCommandInter { // partyControllerServlet.java 에서 사용할 메소드의 인터페이스
	
	String inseParty(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String seleParty(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String selelistParty(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String selePartyre(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String selelistPartyre(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ArrayList<Preview> selelistPreview(HttpServletRequest request, HttpServletResponse response) throws Exception;
	boolean insePreview(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String inseApply(HttpServletRequest request, HttpServletResponse response) throws Exception;
	boolean seleApply(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ArrayList<resdatDTO> selelistmasjip(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ArrayList<resdatDTO> selelistmasjipkor(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ArrayList<resdatDTO> selelistmasjipchn(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ArrayList<resdatDTO> selelistmasjipjpn(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ArrayList<resdatDTO> selelistmasjipwest(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ArrayList<resdatDTO> selelistmasjipworld(HttpServletRequest request, HttpServletResponse response) throws Exception;
	ArrayList<resdatDTO> selelistmasjipwhat(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	public ArrayList<DTO_AD> seleViewtop(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	DTO_AD seleRestau(HttpServletRequest request, HttpServletResponse response) throws Exception;
	resdatDTO seleResdat(HttpServletRequest request, HttpServletResponse response) throws Exception;
	int seleApplycount(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public boolean Applyable(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	String navsearch(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
