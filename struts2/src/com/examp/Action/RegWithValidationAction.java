package com.examp.Action;

import com.examp.ShoppingOnline.User;
import com.examp.ShoppingOnline.hibernate.DBOperator;
import com.opensymphony.xwork2.ActionSupport;

//�û�ע��Ŀ�����
public class RegWithValidationAction extends ActionSupport {
	private String username;	//�û���
	private String password;	//����
	private String password2;	//ȷ������
	private String realname;	//��ʵ����
	private String tel;			//��ϵ�绰
	private String address;		//��ͥ��ַ
	private String zip;			//�ʱ�
	private String email;		//Email��ַ
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String execute() throws Exception {
		if(this.getPassword().equals(this.getPassword2())) {
			User user = new User();
			user.setUsername(this.getUsername());
			user.setPassword(this.getPassword());
			user.setRealname(this.getRealname());
			user.setTel(this.getTel());
			user.setAddress(this.getAddress());
			user.setZip(this.getZip());
			user.setEmail(this.getEmail());
			
			DBOperator op = new DBOperator();
			op.save(user);
			
			return "success";
		}
		return "input";
	}
	
	public void validate() {
		//����û����Ƿ�Ϊ��
		if(username == null || username.trim().equals("")) {
			//д��У�����
			addFieldError("username", "�û�������Ϊ�գ�");
		}
		if(password == null || this.getPassword().trim().equals("")) {
			//д��У�����
			super.addFieldError("password", "���벻��Ϊ��");
		}
		if(!this.getPassword().equals(this.getPassword2())) {
			super.addFieldError("password2", "�����������벻һ����");
		}
	}
}