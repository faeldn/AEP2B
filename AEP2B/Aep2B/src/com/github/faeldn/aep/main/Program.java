package com.github.faeldn.aep.main;

import com.github.faeldn.aep.console.ControllerPacient;

import java.util.Scanner;

import com.github.faeldn.aep.console.ControllerDoc;

/**
 * Programa para agendamento de consultas domiciliares.
 * 
 * <p>
 * Este programa foi desenvolvido para o agendamento de consultas domicilares, pensando no bem estar e comodidade dos pacientes sem precisarem ir aos hospitais em dias de pandemia.
 * 
 * @see
 * Programa desenvolvido por Rafael Vicente de Souza e Julia Piza
 * 
 * @author rafael
 * @version 1.0
 *
 */

public class Program {

	public static void main(String[] args) {
		
		ControllerPacient controllerPacient = new ControllerPacient();
		ControllerDoc controllerDoc = new ControllerDoc();
		
		Scanner menu = new Scanner(System.in);
			
			int opcao = 0;
			
			do {
				System.out.println("~~ SISCON - Sistema de Agendamento de Consultas Domiciliares ~~");
				System.out.println("=========================================================");
				System.out.println("|	1 - Registrar Consulta				|");
				System.out.println("|	2 - Consultar Seu Agendamento			|");
				System.out.println("|	3 - Consultar Todos os Atendimentos		|");
				System.out.println("|	4 - Cancelar Atendimentos			|");
				System.out.println("|	5 - Registar Médico				|");
				System.out.println("|	6 - Consultar Médicos por CRM			|");
				System.out.println("|	7 - Consultar Todos os Médicos Credenciados	|");
				System.out.println("|	0 - Sair					|");
				System.out.println("=========================================================");
				
				System.out.println("Opção: ");
				opcao = menu.nextInt();
				switch (opcao) {
				case 1:
					controllerPacient.add();
					break;
				case 2:
					controllerPacient.listOne();
					break;
				case 3:
					controllerPacient.listAll();
					break;
				case 4:
					controllerPacient.delete();
					break;
				case 5:
					controllerDoc.add();
					break;
				case 6:
					controllerDoc.listOne();
					break;
				case 7:
					controllerDoc.listAll();
					break;
				case 0:
					System.out.println("Obrigado(a)! Até logo!");
					break;
				}
			} while (opcao != 0);
	}
}
