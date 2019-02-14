package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker(String workerName, WorkerLevel workerLevel, Double baseSalary, Department department) {
}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department,
			List<HourContract> contracts) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}


	public Double getBase_Salary() {
		return baseSalary;
	}

	public void setBase_Salary(Double base_Salary) {
		this.baseSalary = base_Salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void remContract(HourContract contract) {
		contracts.remove(contract);
	}
	public Double income(int year, int month) {
		Double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); 
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_month = cal.get(Calendar.MONTH);
			int c_year = 1+cal.get(Calendar.YEAR);
			if(year == c_year && month == c_month) {
			sum+=c.totalValue();
		}
	}return sum;
}
}
