package br.com.oi.sga.poc.view;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.sga.poc.model.User;

@ManagedBean
@SessionScoped
public class UserBean {

	private User user;
	
	private List<String> genderList;
	private List<String> stateList;
	private List<String> cityList;

	@PostConstruct
	public void doInit() {
		user = new User();
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

	public List<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

}
