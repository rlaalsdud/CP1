
public class Subject {

	private int _score;
	
	public Subject() {
		this._score = 0;
	}
	public void setScore (int aScore) {
		this._score = aScore;
	}
	public int score() {
		return this._score;
	}
	public char grade() {
		if(_score >= 90) {
			return 'A';
		}
		else if(_score >= 80) {
			return 'B';
		}
		else if(_score >= 70) {
			return 'C';
		}
		else if(_score >= 60) {
			return 'D';
		}
		else {
			return 'F';
		}
	}
	public double point() {
		switch(grade()){
		case 'A': return 4.0; 
		case 'B': return 3.0;
		case 'C': return 2.0;
		case 'D': return 1.0;
		default:  return 0.0;
		}
	}
}
