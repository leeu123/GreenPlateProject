package restaurant; //������������ ���񽺷� ����


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.SqlMapConfig;
import vo.DTO_AD;
import resdat.resdatDTO;

public class restauAction {
	static restauAction model = new restauAction();

	public static restauAction instance() { // �̱��� ��ü ����
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	
	
	public List<resdatDTO>  selectlistmasjip() { // ���(���)������ 10���� �Ĵ����� �������� �޼ҵ�
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjip");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	
	public List<resdatDTO>  selectlistmasjipkor() { // �ѽ� �� ���(����)������ 10��
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipkor");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipchn() { // �߽� �� ���(����)������ 10��
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipchn");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipjpn() { // �Ͻ� �� ���(����)������ 10��
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipjpn");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipwest() { // ��� �� ���(����)������ 10��
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipwest");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipworld() { // �������� �� ���(����)������ 10��
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipworld");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipwhat() { // ���� �� ���(����)������ 10��
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipwhat");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public DTO_AD  selectRestau(int rnum) {  // �Ĵ��ȣ�� �´� �Ĵ����� ��������
		DTO_AD list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectOne("selectRestau",rnum);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}

	
	
	public resdatDTO  selectResdat(int rnum) {  // �Ĵ� ��ȣ�� �´� ��� �߿� ���� ���� ���� �Ѱ� ��������
		resdatDTO list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectOne("selectResdat",rnum);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	
	public List<DTO_AD> selectViewtop() {  // ��ȸ���� ���� ���� ������ 10��
		List<DTO_AD> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectViewtop");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
		
	}
	
	public List<DTO_AD> navsearch(DTO_AD dtoad){  // �˻��� �Ϳ� �´� �Ĵ� ���� �� ��� ������
		System.out.println("");
		List<DTO_AD> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("navsearch",dtoad);
		System.out.println("aa"+list.size());
		sqlSession.close();
		return list;
	}
	




}
