package member;

import java.time.LocalDateTime;

// ȸ�� ����
public class MemberDTO {
	private String id;					// ���̵�
	private String pw;					// ��й�ȣ
	private String email;				// �̸���
	private String name;				// �̸�
	private String year;				// ����⵵(4�ڸ�)
	private String gender;				// ���� (��,��)
	private String marketing_agree;		// ������ ���ſ���(Y,N)
	private String select_agree;		// ������������ ���ǿ���(Y,N)
	private LocalDateTime signup_date;	// ȸ������ ��¥
	private LocalDateTime login_date;	// ������ �α��� ��¥
	private int cash;					// ���� ĳ��
	private int point;					// ���� ����Ʈ

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarketing_agree() {
		return marketing_agree;
	}

	public void setMarketing_agree(String marketing_agree) {
		this.marketing_agree = marketing_agree;
	}

	public String getSelect_agree() {
		return select_agree;
	}

	public void setSelect_agree(String select_agree) {
		this.select_agree = select_agree;
	}

	public LocalDateTime getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(LocalDateTime signup_date) {
		this.signup_date = signup_date;
	}

	public LocalDateTime getLogin_date() {
		return login_date;
	}

	public void setLogin_date(LocalDateTime login_date) {
		this.login_date = login_date;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
