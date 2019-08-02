
public class Ban {

	private int _capacity;
	private int _numberOfStudents;
	private Student[] _students;
	private double _average;
	private int _numberOfStudnetsWithAboveAverage;
	private int _numberOfStudentsForGradeA;
	private int _numberOfStudentsForGradeB;
	private int _numberOfStudentsForGradeC;
	private int _numberOfStudentsForGradeD;
	private int _numberOfStudentsForGradeF;

	public Ban(int givenCapacity) {
		this._capacity = givenCapacity;
		this._students = new Student[givenCapacity];
		this._numberOfStudents = 0;

		this._average = 0.0;
		this._numberOfStudentsForGradeA=0;
		this._numberOfStudentsForGradeB=0;
		this._numberOfStudentsForGradeC=0;
		this._numberOfStudentsForGradeD=0;
		this._numberOfStudentsForGradeF=0;
	}
	
	public void calcAverageInfo()
	{
		this.average();
		this._numberOfStudnetsWithAboveAverage = 0;
		for(int i=0; i<this._numberOfStudents; i++) {
			if(this._students[i].score() >= this._average) {
				this._numberOfStudnetsWithAboveAverage++;
			}
		}
	}
	
	public double average() {
		int sum=0;
		for(int i=0; i<this._numberOfStudents; i++) {
			sum = sum + this._students[i].score();
		}
		this._average = (double)sum / (double)this._numberOfStudents;
		return this._average;
	}

	public boolean isFull() {
		return this._capacity == this._numberOfStudents;
	}

	public int capacity() {
		return this._capacity;
	}

	public int numberOfStudnets() {
		return this._numberOfStudents;
	}

	public Student studentWithOrderOf(int i_th) {
		return this._students[i_th];
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

	public int numberOfStudnetsWithAboveAverage() {
		return this._numberOfStudnetsWithAboveAverage;
	}

	public void countStudentsByGrade() {
		this._numberOfStudentsForGradeA = 0;
		this._numberOfStudentsForGradeB = 0;
		this._numberOfStudentsForGradeC = 0;
		this._numberOfStudentsForGradeD = 0;
		this._numberOfStudentsForGradeF = 0;

		for(int i=0; i<this._numberOfStudents; i++) {
			switch(this._students[i].grade()) {
			case 'A':
				this._numberOfStudentsForGradeA++;
				break;
			case 'B':
				this._numberOfStudentsForGradeB++;
				break;
			case 'C':
				this._numberOfStudentsForGradeC++;
				break;
			case 'D':
				this._numberOfStudentsForGradeD++;
				break;
			default:
				this._numberOfStudentsForGradeF++;
				break;
			}
		}
	}
	
	public int numberOfStudentsForGradeA() {
		return this._numberOfStudentsForGradeA;
	}
	public int numberOfStudentsForGradeB() {
		return this._numberOfStudentsForGradeB;
	}
	public int numberOfStudentsForGradeC() {
		return this._numberOfStudentsForGradeC;
	}
	public int numberOfStudentsForGradeD() {
		return this._numberOfStudentsForGradeD;
	}
	public int numberOfStudentsForGradeF() {
		return this._numberOfStudentsForGradeF;
	}

}
