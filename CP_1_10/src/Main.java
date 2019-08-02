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
		System.out.print(">세 과목(국어, 영어, 컴퓨터)의 점수를 차례로 입력합니다: ");
		scoreKorean = inputScore();
		scoreEnglish = inputScore();
		scoreComputer = inputScore();
		student.setScoreKorean(scoreKorean);
		student.setScoeEnglish(scoreEnglish);
		student.setScoreComputer(scoreComputer);
		
		while(scoreKorean>=0 && scoreEnglish>=0 && scoreComputer>=0 ) {
			if(scoreKorean>100 || scoreEnglish>100 || scoreComputer>100) {
				System.out.println("오류: 100이 넘어서, 정상적인 점수가 아닙니다.");
			}
			else {
				System.out.println("[국  어]점수: "+student.ScoreKorean()+", 학점: "+student.gradeKorean()+"평점: "+student.pointKorean());
				System.out.println("[영  어]점수: "+student.ScoreEnglish()+", 학점: "+student.gradeEnglish()+"평점: "+student.pointEnglish());
				System.out.println("[컴퓨터]점수: "+student.ScoreComputer()+", 학점: "+student.gradeComputer()+"평점: "+student.pointComputer());
				System.out.println("이 학생의 평균평점은 "+ student.gpa() +" 입니다.");
				counter.count(student.gpa());
			}
			
			System.out.print(">세 과목(국어, 영어, 컴퓨터)의 점수를 차례로 입력합니다: ");
			scoreKorean = inputScore();
			scoreEnglish = inputScore();
			scoreComputer = inputScore();
			student.setScoreKorean(scoreKorean);
			student.setScoeEnglish(scoreEnglish);
			student.setScoreComputer(scoreComputer);
		}
		System.out.println("음의 점수가 입력되어 입력을 종료합니다.");
		
		System.out.println();
		System.out.println("평균평점이 3.0 이상인 학생은 "+ counter.numberOfGPA3() +" 명입니다.");
		System.out.println("평균평점이 2.0 이상인 학생은 "+ counter.numberOfGPA2() +" 명입니다.");
		System.out.println("평균평점이 1.0 이상인 학생은 "+ counter.numberOfGPA1() +" 명입니다.");
		System.out.println("평균평점이 1.0 미만인 학생은 "+ counter.numberOfGPA0() +" 명입니다.");
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	private static int inputScore() {
		int score;
		score = ascanner.nextInt();
		return score;
	}

}
