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

		System.out.println("���α׷��� �����մϴ�.");
	}

	private void inputAndStoreStudentInfo() {
		boolean moreStudentsExist = inputMoreStudentsExist();
		while(moreStudentsExist && (! ban.isFull())) {
			String studentNo = inputStudentNo();
			int score = inputScore();
			if(score < 0 || score > 100) {
				System.out.println("����: 0���� �۰ų� 100���� Ŀ��, �������� ������ �ƴմϴ�.");
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
		System.out.println("�Է��� �����մϴ�.");
		System.out.println();
	}
	private void showStudentInfo() {
		Student aStudent = null;
		System.out.println("�л����� ���� ����Դϴ�.");
		for(int i = 0; i < ban.numberOfStudnets(); i++) {
			aStudent = ban.studentWithOrderOf(i);
		}
		int count = 0;
		int numberOfStudents = ban.numberOfStudnets();
		while(count < numberOfStudents) {
			aStudent = ban.studentWithOrderOf(count);
			System.out.println("�й�: "+ aStudent.studentNo()
			+", ����: "+ aStudent.score() 
			+", ����: "+ aStudent.grade());
			count++;
		}
		System.out.println();
	}
	private void showAverageInfo() {
		System.out.println("��������� " + 	ban.average() +" �Դϴ�.");
		System.out.println("��� �̻��� �л��� ��� " + ban.numberOfStudnetsWithAboveAverage() +" ���Դϴ�.");
		
		int count = 0;
		int numberOfStudents = ban.numberOfStudnets();
		while(count < numberOfStudents) {
			Student aStudent = ban.studentWithOrderOf(count);
			if (aStudent.score() >= ban.average()) {
				System.out.println("�й�: "+ aStudent.studentNo() 
					+", ����: "+ aStudent.score() 
					+", ����: "+ aStudent.grade());
			}
			count++;
		}
		System.out.println();
	}

	private void showGradeInfo() {
		System.out.println();
		System.out.println("A ������ ��� "+ ban.numberOfStudentsForGradeA() +" ���Դϴ�.");
		System.out.println("B ������ ��� "+ ban.numberOfStudentsForGradeB() +" ���Դϴ�.");
		System.out.println("C ������ ��� "+ ban.numberOfStudentsForGradeC() +" ���Դϴ�.");
		System.out.println("D ������ ��� "+ ban.numberOfStudentsForGradeD() +" ���Դϴ�.");
		System.out.println("F ������ ��� "+ ban.numberOfStudentsForGradeF() +" ���Դϴ�.");
		System.out.println();	
	}
	private boolean inputMoreStudentsExist() {
		System.out.print("? �л������� �Է��Ϸ��� 'Y'��, �Է��� �����Ϸ��� 'N'�� ġ�ÿ�: ");
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
		System.out.print("- �й��� �Է��Ͻÿ�: ");
		String studentNo = scanner.next();
		return studentNo;
	}
	private int inputScore() {
		System.out.print("- ������ �Է��Ͻÿ�: ");
		int score = scanner.nextInt();
		return score;
	}

}
