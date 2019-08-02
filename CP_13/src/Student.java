
public class Student {

	private Subject _korean;
	private Subject _english;
	private Subject _computer;
	private double _GPA;
	private String _studentNo;
	
	
	public Student() {
		this._korean =null;
		this._english = null;
		this._computer = null;
		this._GPA = 0;
	}
	public void setKorean (Subject aSubject) {
		this._korean = aSubject;
	}
	public Subject korean() {
		return _korean;
	}
	
	public void setEnglish (Subject aSubject) {
		this._english = aSubject;
	}
	public Subject english() {
		return _english;
	}
	
	public void setComputer (Subject aSubject) {
		this._computer = aSubject;
	}
	public Subject computer() {
		return _computer;
	}
	
	public void setGPA (double aGPA) {
		this._GPA = aGPA;
	}
	public double GPA() {
		return _GPA;
	}
	
	
	
	public void setStudentNo(String aStudentNo) {
		this._studentNo = aStudentNo;
	}
	public String studentNo() {
		return this._studentNo;
	}
}
