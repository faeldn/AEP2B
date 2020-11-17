package com.github.faeldn.aep.models;

public class Doctor {
	Integer crm;
	String docname;
	String spec;
	
	public Doctor(Integer crm, String docname, String spec) {
		super();
		this.crm = crm;
		this.docname = docname;
		this.spec = spec;
	}
	
	public Integer getCrm() {
		return crm;
	}
	public void setCrm(Integer crm) {
		this.crm = crm;
	}
	
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
}
