import java.util.Scanner;

public class AppView {

	private static Scanner _scanner;
	
	public AppView() {
		AppView._scanner = new Scanner(System.in);
	}
	
	public static boolean inputMoreStudentsExist() {
		System.out.println();
		System.out.print("? �л������� �Է��Ϸ��� 'Y'��, �Է��� �����Ϸ��� 'N'�� ġ�ÿ�: ");
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
		System.out.print("- �й��� �Է��Ͻÿ�: ");
		String StudentNo = _scanner.next();
		return StudentNo;
	}
	
	public static int inputScore() {
		int score = _scanner.nextInt();
		return score;
	}
	
	
	public static void outputStudentInfo(Student aStudent) {
		System.out.println("�й�: "+ aStudent.studentNo()+", ����: "+ aStudent.korean().score() +"("+aStudent.korean().grade()+"), "+
				"����: "+aStudent.english().score()+"("+aStudent.english().grade()+"), "+
				"��ǻ��: "+aStudent.computer().score()+"("+aStudent.computer().grade()+"), "+
				"�������: "+aStudent.GPA());
	}
	
	public static void outputAverageInfo(double aClassAverage, int numberOfStudentsAboveAverageGPA) {
		System.out.println("�б��� ��������� "+aClassAverage+" �Դϴ�.");
		System.out.println("������� �̻��� �л����� "+numberOfStudentsAboveAverageGPA+"�� �̻��Դϴ�.");
		System.out.println();
	}
	
	
	public void outputMessage(String aMessgae) {
		System.out.print(aMessgae);
	}

}
