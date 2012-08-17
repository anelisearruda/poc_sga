package br.com.oi.sga.poc.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.sga.poc.model.User;

@ManagedBean
@SessionScoped
public class UserBean {

	private User user;
	
	private List<SelectItem> genderList;
	private List<SelectItem> stateList;
	private List<SelectItem> cityList;
	
	private String currentGender;

	@PostConstruct
	public void doInit() {
		user = new User();
		
		genderList = new ArrayList<SelectItem>();
		genderList.add(new SelectItem("F","F"));
		genderList.add(new SelectItem("M","F"));
		
		stateList = new ArrayList<SelectItem>();
		stateList.add(new SelectItem("MG","MG"));
		stateList.add(new SelectItem("RJ","RJ"));
		stateList.add(new SelectItem("SP","SP"));
		
		cityList = new ArrayList<SelectItem>();
		cityList.add(new SelectItem("Cidade 1","Cidade 1"));
		cityList.add(new SelectItem("Cidade 2","Cidade 2"));
	}
	
	public String send() {
		//Do anything
		return "showResult";
	}
	
	public String goBack() {
		return "send";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SelectItem> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<SelectItem> genderList) {
		this.genderList = genderList;
	}

	public List<SelectItem> getStateList() {
		return stateList;
	}

	public void setStateList(List<SelectItem> stateList) {
		this.stateList = stateList;
	}

	public List<SelectItem> getCityList() {
		return cityList;
	}

	public void setCityList(List<SelectItem> cityList) {
		this.cityList = cityList;
	}

	public String getCurrentGender() {
		return currentGender;
	}

	public void setCurrentGender(String currentGender) {
		this.currentGender = currentGender;
	}
	
}
