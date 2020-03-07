package restaurant; //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ñ½º·ï¿½ ï¿½ï¿½ï¿½ï¿½


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.SqlMapConfig;
import vo.DTO_AD;
import resdat.resdatDTO;

public class restauAction {
	static restauAction model = new restauAction();

	public static restauAction instance() { // ½Ì±ÛÅæ °´Ã¼ »ý¼º
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	
	
	public List<resdatDTO>  selectlistmasjip() { // Æò±Õ(Æò±Õ)¼øÀ¸·Î 10°³ÀÇ ½Ä´çÁ¤º¸ °¡Á®¿À´Â ¸Þ¼Òµå
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjip");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	
	public List<resdatDTO>  selectlistmasjipkor() { // ÇÑ½Ä Áß Æò±Õ(ÆòÁ¡)¼øÀ¸·Î 10°³
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipkor");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipchn() { // Áß½Ä Áß Æò±Õ(ÆòÁ¡)¼øÀ¸·Î 10°³
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipchn");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipjpn() { // ÀÏ½Ä Áß Æò±Õ(ÆòÁ¡)¼øÀ¸·Î 10°³
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipjpn");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipwest() { // ¾ç½Ä Áß Æò±Õ(ÆòÁ¡)¼øÀ¸·Î 10°³
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipwest");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipworld() { // ¼¼°èÀ½½Ä Áß Æò±Õ(ÆòÁ¡)¼øÀ¸·Î 10°³
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipworld");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipwhat() { // ºßÆä Áß Æò±Õ(ÆòÁ¡)¼øÀ¸·Î 10°³
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipwhat");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public DTO_AD  selectRestau(int rnum) {  // ½Ä´ç¹øÈ£¿¡ ¸Â´Â ½Ä´çÁ¤º¸ °¡Á®¿À±â
		DTO_AD list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectOne("selectRestau",rnum);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}

	
	
	public resdatDTO  selectResdat(int rnum) {  // ½Ä´ç ¹øÈ£¿¡ ¸Â´Â ´ñ±Û Áß¿¡ ÆòÁ¡ Á¦ÀÏ ³ôÀº ÇÑ°³ °¡Á®¿À±â
		resdatDTO list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectOne("selectResdat",rnum);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	
	public List<DTO_AD> selectViewtop() {  // Á¶È¸¼ö°¡ °¡Àå ³ôÀº ¼øÀ¸·Î 10°³
		List<DTO_AD> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectViewtop");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
		
	}
	
	public List<DTO_AD> navsearch(DTO_AD dtoad){  // °Ë»öÇÑ °Í¿¡ ¸Â´Â ½Ä´ç Á¤º¸ ¹× ´ñ±Û °¡Á®¿À
		System.out.println("");
		List<DTO_AD> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("navsearch",dtoad);
		System.out.println("aa"+list.size());
		sqlSession.close();
		return list;
	}
	




}
