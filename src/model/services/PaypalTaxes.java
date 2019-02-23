package model.services;

public class PaypalTaxes implements Taxes{

	private static final double PAYMENT_FEES = 0.02;
	private static final double MONTH_FEES = 0.01;
	
	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEES;
	}
	
	@Override
	public double monthFee(double amount, int n) {
		return amount * MONTH_FEES * n;
	}
	
}
