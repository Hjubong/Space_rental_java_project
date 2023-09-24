package com.project.user;

/**
 * 사용자 정보를 저장할 객체입니다.
 * 
 * @author Eunha
 *
 */
public class User {
	private String id; // 아이디
	private String name; // 이름
	private String password; // 비밀번호
	private String tel; // 전화번호
	private String birth; // 생년월일
	private String status; // 탈퇴 여부: y, n
	private int level; // 0 - 관리자, 1 - 회원

	public User(String id, String name, String password, String tel, String birth, String status, int level) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.birth = birth;
		this.status = status;
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", tel=" + tel + ", birth=" + birth
				+ ", status=" + status + ", level=" + level + "]";
	}

}
