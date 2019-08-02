
public class AppController {
	
	private static final int MAXSTUDENTS = 50;
	private AppView  _appView=null;
	private Ban _ban=null;

	public AppController() {
		this._appView = new AppView();
		this._ban = new Ban(MAXSTUDENTS);
	}
	
	public void run() {
		
		this._appView.outputMessage("<<< 성적처리를 시작합니다 >>>\n");
		this.inputAndStoreStudentInfo(); 
		if(this._ban.isEmpty()) { //입력된 학생이 없다면
			this._appView.outputMessage("오류: 입력된 학생 정보가 없습니다.\n");
		}
		else {
			this._ban.processScores(); //학생 정보 출력
			//학급평균평점과 평균 이상인 학생수를  _ban에서 계산한 후 결과 출력
			this.showStudentInfo(); 
			this.showAverageInfo();
		
		}
		
	
		this._appView.outputMessage("<<< 프로그램을 종료합니다 >>>\n");
	}

	private void inputAndStoreStudentInfo() {
		boolean moreStudentsExist = AppView.inputMoreStudentsExist();
		while(moreStudentsExist && (! this._ban.isFull())) {
			String studentNo = AppView.inputStudentNo();
			
			Subject subKor;
			Subject subEng;
			Subject subCom;
			while(true) {
				this._appView.outputMessage("- 국어 점수를 입력하시오: ");
				int korean = AppView.inputScore();
				if(korean<0 || korean>100) {
					this._appView.outputMessage("[오류] 정상 범위 (0~100)의 점수가 아닙니다. 다시 입력하시오.\n");
				}
				else {
					subKor = new Subject();
					subKor.setScore(korean);
					break;
				}
			}
			while(true) {
				this._appView.outputMessage("- 영어 점수를 입력하시오: ");
				int english = AppView.inputScore();
				if(english<0 || english>100) {
					this._appView.outputMessage("[오류] 정상 범위 (0~100)의 점수가 아닙니다. 다시 입력하시오.\n");
				}
				else {
					subEng = new Subject();
					subEng.setScore(english);
					break;
				}
			}
			while(true) {
				this._appView.outputMessage("- 컴퓨터 점수를 입력하시오: ");
				int computer = AppView.inputScore();
				if(computer<0 || computer>100) {
					this._appView.outputMessage("[오류] 정상 범위 (0~100)의 점수가 아닙니다. 다시 입력하시오.\n");
				}
				else {
					subCom = new Subject();
					subCom.setScore(computer);
					break;
				}
			}
			
			Student currentStudent = new Student();
			currentStudent.setStudentNo(studentNo);
			currentStudent.setKorean(subKor);
			currentStudent.setEnglish(subEng);
			currentStudent.setComputer(subCom);
			this._ban.addStudent(currentStudent);
			
			this._appView.outputMessage("\n");
			moreStudentsExist = AppView.inputMoreStudentsExist();

		}
		this._appView.outputMessage("입력을 종료합니다.\n");
		this._appView.outputMessage("\n");
	}

	private void showStudentInfo() {
		this._appView.outputMessage("\n");
		int numberOfStudents=this._ban.numberOfStudents();
		this._appView.outputMessage("학생수는 모두 "+ numberOfStudents +" 명입니다.\n");
		this._appView.outputMessage("\n");
		
		showStudentsListInfo();
		this._appView.outputMessage("\n");
	}

	private void showAverageInfo() {
		AppView.outputAverageInfo(this._ban.classAverageGPA(), this._ban.numberOfStudentsAboveAverageGPA());
	}
	
	private void showStudentsListInfo() {
		this._appView.outputMessage("학생들의 성적 목록입니다.\n");
		
		Student aStudent = null;
		for(int i=0; i<this._ban.numberOfStudents(); i++) {
			aStudent = this._ban.studentWithOrderOf(i);
			AppView.outputStudentInfo(aStudent);
		}
	}
	
	
	
}
