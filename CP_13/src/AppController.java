
public class AppController {
	
	private static final int MAXSTUDENTS = 50;
	private AppView  _appView=null;
	private Ban _ban=null;

	public AppController() {
		this._appView = new AppView();
		this._ban = new Ban(MAXSTUDENTS);
	}
	
	public void run() {
		
		this._appView.outputMessage("<<< ����ó���� �����մϴ� >>>\n");
		this.inputAndStoreStudentInfo(); 
		if(this._ban.isEmpty()) { //�Էµ� �л��� ���ٸ�
			this._appView.outputMessage("����: �Էµ� �л� ������ �����ϴ�.\n");
		}
		else {
			this._ban.processScores(); //�л� ���� ���
			//�б���������� ��� �̻��� �л�����  _ban���� ����� �� ��� ���
			this.showStudentInfo(); 
			this.showAverageInfo();
		
		}
		
	
		this._appView.outputMessage("<<< ���α׷��� �����մϴ� >>>\n");
	}

	private void inputAndStoreStudentInfo() {
		boolean moreStudentsExist = AppView.inputMoreStudentsExist();
		while(moreStudentsExist && (! this._ban.isFull())) {
			String studentNo = AppView.inputStudentNo();
			
			Subject subKor;
			Subject subEng;
			Subject subCom;
			while(true) {
				this._appView.outputMessage("- ���� ������ �Է��Ͻÿ�: ");
				int korean = AppView.inputScore();
				if(korean<0 || korean>100) {
					this._appView.outputMessage("[����] ���� ���� (0~100)�� ������ �ƴմϴ�. �ٽ� �Է��Ͻÿ�.\n");
				}
				else {
					subKor = new Subject();
					subKor.setScore(korean);
					break;
				}
			}
			while(true) {
				this._appView.outputMessage("- ���� ������ �Է��Ͻÿ�: ");
				int english = AppView.inputScore();
				if(english<0 || english>100) {
					this._appView.outputMessage("[����] ���� ���� (0~100)�� ������ �ƴմϴ�. �ٽ� �Է��Ͻÿ�.\n");
				}
				else {
					subEng = new Subject();
					subEng.setScore(english);
					break;
				}
			}
			while(true) {
				this._appView.outputMessage("- ��ǻ�� ������ �Է��Ͻÿ�: ");
				int computer = AppView.inputScore();
				if(computer<0 || computer>100) {
					this._appView.outputMessage("[����] ���� ���� (0~100)�� ������ �ƴմϴ�. �ٽ� �Է��Ͻÿ�.\n");
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
		this._appView.outputMessage("�Է��� �����մϴ�.\n");
		this._appView.outputMessage("\n");
	}

	private void showStudentInfo() {
		this._appView.outputMessage("\n");
		int numberOfStudents=this._ban.numberOfStudents();
		this._appView.outputMessage("�л����� ��� "+ numberOfStudents +" ���Դϴ�.\n");
		this._appView.outputMessage("\n");
		
		showStudentsListInfo();
		this._appView.outputMessage("\n");
	}

	private void showAverageInfo() {
		AppView.outputAverageInfo(this._ban.classAverageGPA(), this._ban.numberOfStudentsAboveAverageGPA());
	}
	
	private void showStudentsListInfo() {
		this._appView.outputMessage("�л����� ���� ����Դϴ�.\n");
		
		Student aStudent = null;
		for(int i=0; i<this._ban.numberOfStudents(); i++) {
			aStudent = this._ban.studentWithOrderOf(i);
			AppView.outputStudentInfo(aStudent);
		}
	}
	
	
	
}
