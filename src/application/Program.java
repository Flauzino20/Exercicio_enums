package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com o nome do Departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("Entre com os dados do Trabalhador: ");
		System.out.print("Digite o nome: ");
		String workerName = sc.nextLine();
		System.out.println("Digite o Nível: ");
		String workerLevel = sc.nextLine();
		System.out.println("Digite o Salário Base: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department (departmentName));
		System.out.println("Digite a quantidade contratos do funcionário: ");
		int n = sc.nextInt();
		for (int i = 1; i<=n; i++) {
		System.out.println("Entre com contrato #" + i + ": ");	
		System.out.println("Data (DD/MM/YYYY): ");
		Date contractDate = sdf.parse(sc.next());
		System.out.print("Digite o Valor por hora: ");
		Double valuePerHour = sc.nextDouble();
		System.out.println("Digite a duração em horas: ");
		int hours = sc.nextInt();
		HourContract contract = new HourContract(contractDate, valuePerHour, hours);
		worker.addContract(contract);
		
		}
		System.out.println();
		System.out.println("Entre com o mês e ano do contrato (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println(" Departamento: " + worker.getDepartment().getName());
		System.out.println(" Recebeu em " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
				
		sc.close();

	}

}
