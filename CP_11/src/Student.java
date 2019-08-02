
public class Student {

	private String _studentNo;
	private int _score;
	
	public Student() {
		this._studentNo = null;
		this._score = 0;
	}
	public void setScore(int aScore) {
		this._score = aScore;
	}
	public int score() {
		return this._score;
	}
	public char grade(int aScore) {
		if(aScore >= 90) {
			return 'A';
		}
		else if(aScore >= 80) {
			return 'B';
		}
		else if(aScore >= 70) {
			return 'C';
		}
		else if(aScore >= 60) {
			return 'D';
		}
		else {
			return 'F';
		}
	}
	public void setStudentNo(String aStudentNo) {//setter
		this._studentNo = aStudentNo;
	}
	public String studentNo() {//getter
		return this._studentNo;
	}
}

