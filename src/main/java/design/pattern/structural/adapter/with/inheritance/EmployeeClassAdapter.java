package design.pattern.structural.adapter.with.inheritance;

/**
 * A class adapter, works as Two-way adapter
 */
public class EmployeeClassAdapter extends Employee implements Customer {

    @Override
    public String getName() {
        return super.getFullName();
    }

    @Override
    public String getDesignation() {
        return super.getJobTitle();
    }

    @Override
    public String getAddress() {
        return super.getOfficeLocation();
    }
	
}
