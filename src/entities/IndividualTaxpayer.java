package entities;

public final class IndividualTaxpayer extends Taxpayer {

	private Double healthExpenditures;
	
	public IndividualTaxpayer() {
		super();
	}
	public IndividualTaxpayer(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}
	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public Double tax() {
		double taxRate;
		
		taxRate = (getAnnualIncome() < 20000.00) ? 0.15 : 0.25;
		return getAnnualIncome() * taxRate - getHealthExpenditures() * 0.50;
	}

}
