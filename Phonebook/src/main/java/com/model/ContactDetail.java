package com.model;

import java.io.Serializable;
import java.util.List;

import com.services.impl.ManagedLoginBean;

public class ContactDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7406033583537431867L;
	private Long id;
	private String phoneNum1;
	private String phoneNum2;
	private String name;

	public ContactDetail() {
	}

	private List<ContactDetail> phoneBookList;

	public String getPhoneNum2() {
		return phoneNum2;
	}

	public String getPhoneNum1() {
		return phoneNum1;
	}

	public void setPhoneNum1(String phoneNum1) {
		this.phoneNum1 = phoneNum1;
	}

	public void setPhoneNum2(String phoneNum2) {
		this.phoneNum2 = phoneNum2;
	}

	public List<ContactDetail> getPhoneBookList() {
		return phoneBookList;
	}

	public void setPhoneBookList(List<ContactDetail> phoneBookList) {
		this.phoneBookList = phoneBookList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String saveUserDetails() {
		ManagedLoginBean managedLoginBean = new ManagedLoginBean();
		ContactDetail bean = new ContactDetail();
		bean.setName(this.getName());
		bean.setPhoneNum1(this.getPhoneNum1());
		managedLoginBean.insertLoginDetail(bean);
		getPhoneBookListFromDB();
		return "success";

	}

	public String getPhoneBookListFromDB() {
		ManagedLoginBean managedLoginBean = new ManagedLoginBean();
		List<ContactDetail> beanlist = managedLoginBean.getPhoneBookDetails();
		if (beanlist.size() > 0) {
			setPhoneBookList(beanlist);
		}
		return null;
	}

}
