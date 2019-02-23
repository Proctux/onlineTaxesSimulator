package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installments;

public class OnlinePaymentServices {

	private Taxes taxes;
	
	public OnlinePaymentServices() {
	}
	public OnlinePaymentServices(Taxes taxes) {
		this.taxes = taxes;
	}
	
	public void processContract(Contract contract, int months) {
		double basicValues = contract.getContractValue() / months;
		
		for(int i = 1; i <= months; i++) {
			Date date = addMonths(contract.getDate(), i);
			double updateQuota = basicValues + taxes.monthFee(basicValues, i);
			double fullQuota = updateQuota + taxes.paymentFee(updateQuota);
			contract.addInstallment(new Installments(date, fullQuota));
		}
	}
	
	public Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
}
