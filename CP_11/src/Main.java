import java.util.Scanner;

public class Main {
	private static final int MAXSTUDENTS = 50;
	private static Scanner ascanner = new Scanner(System.in);
	
	private static int numberOfStudents=0;
	private static Student[] c1;
	private static double average = 0;
	private static int aboveAverage = 0;
	private static int numberOfGradeA=0;
	private static int numberOfGradeB=0;
	private static int numberOfGradeC=0;
	private static int numberOfGradeD=0;
	private static int numberOfGradeF=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		c1 = new Student[MAXSTUDENTS]; //�л������迭
		
		inputAndStoreStudentInfo();
		showStudentInfo();
		calcAverage();
		showAverageInfo(); 
		countStudentsByGrade();
		showGradeInfo();
		
		System.out.println("���α׷��� �����մϴ�.");
	}
	private static void inputAndStoreStudentInfo() {
		// TODO Auto-generated method stub
		boolean moreStudentsExist = inputMoreStudentsExist(); 
		while(moreStudentsExist && numberOfStudents < MAXSTUDENTS) {
			String studentNo = inputStudentNo();
			int score = inputScore();
			if(score < 0 || score > 100) {
				System.out.println("����: 0���� �۰ų� 100���� Ŀ��, �������� ������ �ƴմϴ�.");
			}
			else {
				Student currentStudent = new Student();
				currentStudent.setStudentNo(studentNo);
				currentStudent.setScore(score);
				c1[numberOfStudents] = currentStudent;
				numberOfStudents++;
			}
			moreStudentsExist = inputMoreStudentsExist(); 
		}
		  
	}
	private static void showGradeInfo() {
		System.out.println();
		System.out.println("A ������ ��� "+ numberOfGradeA +" ���Դϴ�.");
		System.out.println("B ������ ��� "+ numberOfGradeB +" ���Դϴ�.");
		System.out.println("C ������ ��� "+ numberOfGradeC +" ���Դϴ�.");
		System.out.println("D ������ ��� "+ numberOfGradeD +" ���Դϴ�.");
		System.out.println("F ������ ��� "+ numberOfGradeF +" ���Դϴ�.");
		System.out.println();	
	}
	private static void countStudentsByGrade() {
		char currentGrade;
		for(int i=0; i<numberOfStudents; i++) {
			currentGrade = c1[i].grade(c1[i].score());
			if(currentGrade == 'A') {
				numberOfGradeA++;
			}
			else if(currentGrade == 'B') {
				numberOfGradeB++;
			}
			else if(currentGrade == 'C') {
				numberOfGradeC++;

			}else if(currentGrade == 'D') {
				numberOfGradeD++;
			}
			else {
				numberOfGradeF++;
			}
		}
	}
	
	private static void calcAverage() {
		int i = 0;
		int sum=0;
		while(i < numberOfStudents) {
			sum = sum + c1[i].score();
			average = (double)sum / (double)numberOfStudents;
			i++;
		}
		
		i = 0;
		while(i < numberOfStudents) {
			if(c1[i].score() >= average) {
				aboveAverage++;
			}i++;
		}
	}
	private static void showAverageInfo() {
		System.out.println("��������� " + average +" �Դϴ�.");
		System.out.println("��� �̻��� �л��� ��� " + aboveAverage +" ���Դϴ�.");
		
	}
	private static void showStudentInfo() {
		System.out.println("�л����� ���� ����Դϴ�.");
		int count = 0;
		while(count < numberOfStudents) {
			System.out.println("�й�: "+ c1[count].studentNo() +", ����: "+ c1[count].score() +", ����: "+ c1[count].grade(c1[count].score()));
			count++;
		}
		System.out.println();
	}

	
	private static boolean inputMoreStudentsExist() {
		System.out.print("? �л������� �Է��Ϸ��� 'Y'��, �Է��� �����Ϸ��� 'N'�� ġ�ÿ�: ");
		char MoreStudentsExist = 0;
		
		MoreStudentsExist=ascanner.next().charAt(0);
		if(MoreStudentsExist == 'Y' || MoreStudentsExist == 'y') {
			return true;
		}
		else {
			return false;
		}
	}
	private static String inputStudentNo() {
		System.out.print("- �й��� �Է��Ͻÿ�: ");
		String studentNo = ascanner.next();
		return studentNo;
	}
	private static int inputScore() {
		System.out.print("- ������ �Է��Ͻÿ�: ");
		int score = ascanner.nextInt();
		return score;
	}

}
