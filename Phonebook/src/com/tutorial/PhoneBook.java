package com.tutorial;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.tutorial.services.impl.ManagedLoginBean;

@Entity
public class PhoneBook {

	@Id
	private String phoneNum;
	private String name;

	@Transient
	private List<PhoneBook> phoneBookList;

	public List<PhoneBook> getPhoneBookList() {
		return phoneBookList;
	}

	public void setPhoneBookList(List<PhoneBook> phoneBookList) {
		this.phoneBookList = phoneBookList;
	}
	

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String saveUserDetails() {
		ManagedLoginBean managedLoginBean = new ManagedLoginBean();
		PhoneBook bean = new PhoneBook();
		bean.setName(this.getName());
		bean.setPhoneNum(this.getPhoneNum());
		managedLoginBean.insertLoginDetail(bean);
		getPhoneBookListFromDB();
		return "success";

	}
	
	public String getPhoneBookListFromDB(){
		ManagedLoginBean managedLoginBean = new ManagedLoginBean();
		List<PhoneBook> beanlist = managedLoginBean.getPhoneBookDetails();
		if(beanlist.size()>0){
			setPhoneBookList(beanlist);
		}
		return null;
	}

}
