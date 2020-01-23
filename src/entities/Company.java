package entities;

public final class Company extends Taxpayer {

	private Integer numberOfEmployees;
	
	public Company() {
		super();
	}
	public Company(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	@Override
	public final Double tax() {
		double taxRate;
		
		taxRate = (getNumberOfEmployees() > 10) ? 0.14 : 0.16;
		return getAnnualIncome() * taxRate;
	}

}
