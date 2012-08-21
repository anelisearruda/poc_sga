package br.com.oi.sga.poc.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.oi.sga.poc.model.User;

@ManagedBean
@SessionScoped
public class UserBean {

	private User user;
	private List<User> users;
	private List<User> filteredUsers;
	private List<SelectItem> genderList;
	private List<SelectItem> stateList;
	private List<SelectItem> cityList;

	@PostConstruct
	public void doInit() {
		
		user = new User();
		users = new ArrayList<User>();
		genderList = new ArrayList<SelectItem>();
		genderList.add(new SelectItem("F", "Feminino"));
		genderList.add(new SelectItem("M", "Masculino"));

		stateList = new ArrayList<SelectItem>();
		stateList.add(new SelectItem("MG", "MG"));
		stateList.add(new SelectItem("RJ", "RJ"));
		stateList.add(new SelectItem("SP", "SP"));

		cityList = new ArrayList<SelectItem>();
		cityList.add(new SelectItem("Cidade 1", "Cidade 1"));
		cityList.add(new SelectItem("Cidade 2", "Cidade 2"));
	}

	public String toShowResult() {
		users.add(user);
		user = new User();
		return "showResult";
	}

	public String toSend() {
		return "send";
	}

	public String toIndex() {
		return "index";
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public void deleteUser() {
		users.remove(user);
		user = new User();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage("Sucesso",
				"Usuário excluído com sucesso!"));
	}

	public void loadObjectToBeDeleted(User user) {
		this.user = user;
	}

}
