package model.services;

public interface Taxes {

	double paymentFee(double amount);
	double monthFee(double amount, int n);
	
}
