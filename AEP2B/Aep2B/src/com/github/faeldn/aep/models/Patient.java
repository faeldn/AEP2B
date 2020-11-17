package com.github.faeldn.aep.models;

public class Patient {
	String cpf;
	String name;
	Long cel;
	String birthdate;
	String adress;
	String cep;
	String city;
	String state;
	String suscode;
	String namemom;
	String infcompl;

	public Patient(String cpf, String name, Long cel, String birthdate, String adress, String cep, String city,
			String state, String suscode, String namemom, String infcompl) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.cel = cel;
		this.birthdate = birthdate;
		this.adress = adress;
		this.cep = cep;
		this.city = city;
		this.state = state;
		this.suscode = suscode;
		this.namemom = namemom;
		this.infcompl = infcompl;

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCel() {
		return cel;
	}

	public void setCel(Long cel) {
		this.cel = cel;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSuscode() {
		return suscode;
	}

	public void setSuscode(String suscode) {
		this.suscode = suscode;
	}

	public String getNamemom() {
		return namemom;
	}

	public void setNamemom(String namemom) {
		this.namemom = namemom;
	}

	public String getInfcompl() {
		return infcompl;
	}

	public void setInfcompl(String infcompl) {
		this.infcompl = infcompl;
	}

}
