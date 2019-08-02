import java.util.Scanner;
public class Main {
	private static Scanner ascanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int scoreKorean;
      int scoreEnglish;
      int scoreComputer;
      
      GPACounter counter = new GPACounter();
        Student student = new Student();
		System.out.print(">�� ����(����, ����, ��ǻ��)�� ������ ���ʷ� �Է��մϴ�: ");
		scoreKorean = inputScore();
		scoreEnglish = inputScore();
		scoreComputer = inputScore();
		student.setScoreKorean(scoreKorean);
		student.setScoeEnglish(scoreEnglish);
		student.setScoreComputer(scoreComputer);
		
		while(scoreKorean>=0 && scoreEnglish>=0 && scoreComputer>=0 ) {
			if(scoreKorean>100 || scoreEnglish>100 || scoreComputer>100) {
				System.out.println("����: 100�� �Ѿ, �������� ������ �ƴմϴ�.");
			}
			else {
				System.out.println("[��  ��]����: "+student.ScoreKorean()+", ����: "+student.gradeKorean()+"����: "+student.pointKorean());
				System.out.println("[��  ��]����: "+student.ScoreEnglish()+", ����: "+student.gradeEnglish()+"����: "+student.pointEnglish());
				System.out.println("[��ǻ��]����: "+student.ScoreComputer()+", ����: "+student.gradeComputer()+"����: "+student.pointComputer());
				System.out.println("�� �л��� ��������� "+ student.gpa() +" �Դϴ�.");
				counter.count(student.gpa());
			}
			
			System.out.print(">�� ����(����, ����, ��ǻ��)�� ������ ���ʷ� �Է��մϴ�: ");
			scoreKorean = inputScore();
			scoreEnglish = inputScore();
			scoreComputer = inputScore();
			student.setScoreKorean(scoreKorean);
			student.setScoeEnglish(scoreEnglish);
			student.setScoreComputer(scoreComputer);
		}
		System.out.println("���� ������ �ԷµǾ� �Է��� �����մϴ�.");
		
		System.out.println();
		System.out.println("��������� 3.0 �̻��� �л��� "+ counter.numberOfGPA3() +" ���Դϴ�.");
		System.out.println("��������� 2.0 �̻��� �л��� "+ counter.numberOfGPA2() +" ���Դϴ�.");
		System.out.println("��������� 1.0 �̻��� �л��� "+ counter.numberOfGPA1() +" ���Դϴ�.");
		System.out.println("��������� 1.0 �̸��� �л��� "+ counter.numberOfGPA0() +" ���Դϴ�.");
		System.out.println("���α׷��� �����մϴ�.");
		
	}
	
	private static int inputScore() {
		int score;
		score = ascanner.nextInt();
		return score;
	}

}
