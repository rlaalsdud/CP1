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
		c1 = new Student[MAXSTUDENTS]; //학생정보배열
		
		inputAndStoreStudentInfo();
		showStudentInfo();
		calcAverage();
		showAverageInfo(); 
		countStudentsByGrade();
		showGradeInfo();
		
		System.out.println("프로그램을 종료합니다.");
	}
	private static void inputAndStoreStudentInfo() {
		// TODO Auto-generated method stub
		boolean moreStudentsExist = inputMoreStudentsExist(); 
		while(moreStudentsExist && numberOfStudents < MAXSTUDENTS) {
			String studentNo = inputStudentNo();
			int score = inputScore();
			if(score < 0 || score > 100) {
				System.out.println("오류: 0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다.");
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
		System.out.println("A 학점은 모두 "+ numberOfGradeA +" 명입니다.");
		System.out.println("B 학점은 모두 "+ numberOfGradeB +" 명입니다.");
		System.out.println("C 학점은 모두 "+ numberOfGradeC +" 명입니다.");
		System.out.println("D 학점은 모두 "+ numberOfGradeD +" 명입니다.");
		System.out.println("F 학점은 모두 "+ numberOfGradeF +" 명입니다.");
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
		System.out.println("평균점수는 " + average +" 입니다.");
		System.out.println("평균 이상인 학생은 모두 " + aboveAverage +" 명입니다.");
		
	}
	private static void showStudentInfo() {
		System.out.println("학생들의 성적 목록입니다.");
		int count = 0;
		while(count < numberOfStudents) {
			System.out.println("학번: "+ c1[count].studentNo() +", 점수: "+ c1[count].score() +", 학점: "+ c1[count].grade(c1[count].score()));
			count++;
		}
		System.out.println();
	}

	
	private static boolean inputMoreStudentsExist() {
		System.out.print("? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 'N'을 치시오: ");
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
		System.out.print("- 학번을 입력하시오: ");
		String studentNo = ascanner.next();
		return studentNo;
	}
	private static int inputScore() {
		System.out.print("- 점수를 입력하시오: ");
		int score = ascanner.nextInt();
		return score;
	}

}
