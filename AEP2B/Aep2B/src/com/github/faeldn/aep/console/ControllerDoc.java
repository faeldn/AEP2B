package com.github.faeldn.aep.console;

import java.util.List;
import java.util.Scanner;

import com.github.faeldn.aep.models.Doctor;
import com.github.faeldn.aep.repository.RepositoryDocDB;

public class ControllerDoc {
	
	private RepositoryDocDB repositoryDoc = new RepositoryDocDB();
	private Scanner scan = new Scanner(System.in);
	
	public void listAll() {
		List<Doctor> list = this.repositoryDoc.all();
		
		if (list.isEmpty()) {
			System.out.println("Nenhum médico cadastrado"); 
		}
		
		list.forEach (u -> {
			System.out.println("Nome: " + u.getDocname());
			System.out.println("Especialidade: " + u.getSpec());
			System.out.println("CRM: " + u.getCrm());
			System.out.println("_________________");
		});
	}
	
	public void listOne() {
		System.out.println("Digite o CRM a ser consultado: ");
		int crm = scan.nextInt();
		scan.nextLine();
		Doctor doctor = repositoryDoc.one(crm);
		if (doctor!=null) {
			System.out.println("CRM: " + doctor.getCrm());
			System.out.println("Nome do(a) médico(a): " + doctor.getDocname());
			System.out.println("Especialidade médica: " + doctor.getSpec());
			System.out.println("__________________________");
		} else {
		System.out.println("Médico não encontrado!");
		}
	}
	
	public void add() {
		String docname;
		String spec;
		Integer crm;
		
		System.out.println("Digite o CRM: ");
		crm = scan.nextInt();
		scan.nextLine();
		System.out.println("Informe o nome completo do(a) médico(a): ");
		docname = scan.nextLine();
		System.out.println("Informe a especialidade: ");
		spec = scan.nextLine();
		Doctor p = new Doctor(crm, docname, spec);
		repositoryDoc.insert(p);
		System.out.println("Médico cadastrado!");
		
	}

}
