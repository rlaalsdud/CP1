import java.util.Scanner;

public class AppView {

	private static Scanner _scanner;
	
	public AppView() {
		AppView._scanner = new Scanner(System.in);
	}
	
	public static boolean inputMoreStudentsExist() {
		System.out.println();
		System.out.print("? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 'N'을 치시오: ");
		char MoreStudentsExist = 0;

		MoreStudentsExist=_scanner.next().charAt(0);
		if(MoreStudentsExist == 'Y' || MoreStudentsExist == 'y') {
			return true;
		}
		else {
			return false;
		}
	}
	

	public static String inputStudentNo() {
		System.out.print("- 학번을 입력하시오: ");
		String StudentNo = _scanner.next();
		return StudentNo;
	}
	
	public static int inputScore() {
		int score = _scanner.nextInt();
		return score;
	}
	
	
	public static void outputStudentInfo(Student aStudent) {
		System.out.println("학번: "+ aStudent.studentNo()+", 국어: "+ aStudent.korean().score() +"("+aStudent.korean().grade()+"), "+
				"영어: "+aStudent.english().score()+"("+aStudent.english().grade()+"), "+
				"컴퓨터: "+aStudent.computer().score()+"("+aStudent.computer().grade()+"), "+
				"평균평점: "+aStudent.GPA());
	}
	
	public static void outputAverageInfo(double aClassAverage, int numberOfStudentsAboveAverageGPA) {
		System.out.println("학급의 평균평점은 "+aClassAverage+" 입니다.");
		System.out.println("평균평점 이상인 학생수는 "+numberOfStudentsAboveAverageGPA+"명 이상입니다.");
		System.out.println();
	}
	
	
	public void outputMessage(String aMessgae) {
		System.out.print(aMessgae);
	}

}
