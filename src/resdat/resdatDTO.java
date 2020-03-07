package resdat;

public class resdatDTO {
	// 식당 댓글 필드명
	int dnum;
	int rnum;
	String id;
	String nick;
	int pyung;
	String dcontent;
	String date;
	
	// SQL 에서 값을 받기 위한 변수
	double avg_pyung; // SQL에서 평점의 평균을 받기 위한 double 값 
	String store;   // 식당 정보를 가져오기 위한 식당 이름 
    String postnum;  // 식당 정보의 지번
	String home; // 식당 정보의 주소
	String dethome; // 식당 정보의 상세 주소
	String file;  // 식당 정보의 파일 이름들
	int readcount;  // 식당 조회수

	public double getAvg_pyung() {
		return avg_pyung;
	}
	public void setAvg_pyung(double avg_pyung) {
		this.avg_pyung = avg_pyung;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getPyung() {
		return pyung;
	}
	public void setPyung(int pyung) {
		this.pyung = pyung;
	}
	public String getDcontent() {
		return dcontent;
	}
	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getPostnum() {
		return postnum;
	}
	public void setPostnum(String postnum) {
		this.postnum = postnum;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getDethome() {
		return dethome;
	}
	public void setDethome(String dethome) {
		this.dethome = dethome;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	
	
	
}
