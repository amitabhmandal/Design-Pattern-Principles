package design.pattern.structural.adapter.with.inheritance;

public class Main {

	public static void main(String[] args) {
	    
	    EmployeeClassAdapter employeeAdapter = new EmployeeClassAdapter();
	    populateEmployeeData(employeeAdapter);
	    BusinessCardDesigner businessCardDesigner = new BusinessCardDesigner();
	    System.out.println(businessCardDesigner.designCard(employeeAdapter));
	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("Amitabh");
		employee.setJobTitle("Developer");
		employee.setOfficeLocation("Home");
	}
}
