
public class Ban {

	private int _maxNumberOfStudents;
	private int _numberOfStudents;
	private Student[] _students;
	private double _classAverageGPA;
	private int _numberOfStudentsAboveAverageGPA ;
	
	

	public Ban(int givenmaxNumberOfStudents) {
		this._maxNumberOfStudents = givenmaxNumberOfStudents;
		this._students = new Student[givenmaxNumberOfStudents];
		this._numberOfStudents = 0;
		this._classAverageGPA = 0;
		this._numberOfStudentsAboveAverageGPA = 0;
	}
	
	public boolean isFull() {
		return this._maxNumberOfStudents == this._numberOfStudents;
	}
	public boolean isEmpty() {
		return this._maxNumberOfStudents == this._numberOfStudents;
	}
	
	public int maxNumberOfStudents() {
		return this._maxNumberOfStudents;
	}
	public int numberOfStudents() {
		return this._numberOfStudents;
	} 
	public double classAverageGPA() {
		return this._classAverageGPA;
	}
	public int numberOfStudentsAboveAverageGPA() {
		return this._numberOfStudentsAboveAverageGPA;
	} 
	
	public boolean addStudent(Student aStudent) {
		if (this.isFull()) {
			return false;
		}else {
			this._students[this._numberOfStudents] = aStudent;
			this._numberOfStudents++;
			return true;
		}
	}
	public Student studentWithOrderOf(int order) {
		return this._students[order];
	}

	
	public boolean processScores() {
		for (int i=0; i<this._numberOfStudents; i++) {
			Student aStu = this._students[i];
			double sum = aStu.korean().point() + aStu.english().point() + aStu.computer().point();
			this._students[i].setGPA( sum / 3 );
		}
		
		double gpa=0;
		for (int i=0; i<this._numberOfStudents; i++) {
			gpa += this._students[i].GPA();
		}
		this._classAverageGPA = gpa / this._numberOfStudents;
		
		for (int i=0; i<this._numberOfStudents; i++) {
			if (this._students[i].GPA() >= this._classAverageGPA) {
				this._numberOfStudentsAboveAverageGPA++;
			}
		}
		return true;
	}
	
}	
	
	
	
	
	
