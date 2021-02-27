
public enum TiwilioOperators {
	GSM7(0.01, 160), UCS2(0.015, 70);
	private double charges;
	private int limi;
	private TiwilioOperators(double charges, int limit) {
		this.charges = charges;
		this.limi = limit;
	}
	
	public double getCharges() {
		return charges;
	}
	
	public int getLimit() {
		return limi;
	}
}
