import java.util.Scanner;

public class AppController {
	private static final int MAXSTUDENTS = 50;
	private Scanner scanner = new Scanner(System.in);
	private Ban ban; 

	public AppController() {
		ban = new Ban(MAXSTUDENTS);
	}
	public void run() { 
		this.inputAndStoreStudentInfo();
		showStudentInfo();
		ban.calcAverageInfo();
		showAverageInfo();
		ban.countStudentsByGrade();
		showGradeInfo();

		System.out.println("프로그램을 종료합니다.");
	}

	private void inputAndStoreStudentInfo() {
		boolean moreStudentsExist = inputMoreStudentsExist();
		while(moreStudentsExist && (! ban.isFull())) {
			String studentNo = inputStudentNo();
			int score = inputScore();
			if(score < 0 || score > 100) {
				System.out.println("오류: 0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다.");
			}
			else {
				Student currentStudent = new Student();
				currentStudent.setStudentNo(studentNo);
				currentStudent.setScore(score);
				ban.addStudent(currentStudent);
			}
			System.out.println();
			moreStudentsExist = inputMoreStudentsExist();

		}
		System.out.println("입력을 종료합니다.");
		System.out.println();
	}
	private void showStudentInfo() {
		Student aStudent = null;
		System.out.println("학생들의 성적 목록입니다.");
		for(int i = 0; i < ban.numberOfStudnets(); i++) {
			aStudent = ban.studentWithOrderOf(i);
		}
		int count = 0;
		int numberOfStudents = ban.numberOfStudnets();
		while(count < numberOfStudents) {
			aStudent = ban.studentWithOrderOf(count);
			System.out.println("학번: "+ aStudent.studentNo()
			+", 점수: "+ aStudent.score() 
			+", 학점: "+ aStudent.grade());
			count++;
		}
		System.out.println();
	}
	private void showAverageInfo() {
		System.out.println("평균점수는 " + 	ban.average() +" 입니다.");
		System.out.println("평균 이상인 학생은 모두 " + ban.numberOfStudnetsWithAboveAverage() +" 명입니다.");
		
		int count = 0;
		int numberOfStudents = ban.numberOfStudnets();
		while(count < numberOfStudents) {
			Student aStudent = ban.studentWithOrderOf(count);
			if (aStudent.score() >= ban.average()) {
				System.out.println("학번: "+ aStudent.studentNo() 
					+", 점수: "+ aStudent.score() 
					+", 학점: "+ aStudent.grade());
			}
			count++;
		}
		System.out.println();
	}

	private void showGradeInfo() {
		System.out.println();
		System.out.println("A 학점은 모두 "+ ban.numberOfStudentsForGradeA() +" 명입니다.");
		System.out.println("B 학점은 모두 "+ ban.numberOfStudentsForGradeB() +" 명입니다.");
		System.out.println("C 학점은 모두 "+ ban.numberOfStudentsForGradeC() +" 명입니다.");
		System.out.println("D 학점은 모두 "+ ban.numberOfStudentsForGradeD() +" 명입니다.");
		System.out.println("F 학점은 모두 "+ ban.numberOfStudentsForGradeF() +" 명입니다.");
		System.out.println();	
	}
	private boolean inputMoreStudentsExist() {
		System.out.print("? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 'N'을 치시오: ");
		char MoreStudentsExist = 0;

		MoreStudentsExist= scanner.next().charAt(0);
		if(MoreStudentsExist == 'Y' || MoreStudentsExist == 'y') {
			return true;
		}
		else {
			return false;
		}
	}
		
	private String inputStudentNo() {
		System.out.print("- 학번을 입력하시오: ");
		String studentNo = scanner.next();
		return studentNo;
	}
	private int inputScore() {
		System.out.print("- 점수를 입력하시오: ");
		int score = scanner.nextInt();
		return score;
	}

}
