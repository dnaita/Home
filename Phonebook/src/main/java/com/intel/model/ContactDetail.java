package com.intel.model;

import java.util.List;

import com.intel.services.impl.ManagedLoginBean;

public class ContactDetail {

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

	public void setPhoneNum2(String phoneNum2) {
		this.phoneNum2 = phoneNum2;
	}

	public List<ContactDetail> getPhoneBookList() {
		return phoneBookList;
	}

	public void setPhoneBookList(List<ContactDetail> phoneBookList) {
		this.phoneBookList = phoneBookList;
	}

	public String getPhoneNum() {
		return phoneNum1;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum1 = phoneNum;
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
		bean.setPhoneNum(this.getPhoneNum());
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
