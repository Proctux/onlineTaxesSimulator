package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.OnlinePaymentServices;
import model.services.PaypalTaxes;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Enter contract data");
		System.out.print("Contract number: ");
		Integer number = sc.nextInt();
		System.out.print("Contract date: ");
		sc.nextLine();
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double contractValue = sc.nextDouble();
		
		Contract ct = new Contract(number, date, contractValue);
		
		System.out.print("Enter the number of installments: ");
		int n = sc.nextInt();
		
		OnlinePaymentServices ops = new OnlinePaymentServices(new PaypalTaxes());
		
		ops.processContract(ct, n);
		
		System.out.println("INSTALLMENTS: ");
		for(Installments e : ct.getList()) {
			System.out.println(e);
		}
		
		sc.close();
	}

}
