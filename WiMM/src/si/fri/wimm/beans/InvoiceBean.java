package si.fri.wimm.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import si.fri.wimm.entity.Invoice;

@Named
@SessionScoped
public class InvoiceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2620333182847578748L;
	
	private List<Invoice> invoices;
	private int invoiceId;
	private String imageName;
	public InvoiceBean(){
		invoiceId=1;
		setInvoices(new ArrayList<Invoice>());
	}
	
	public List<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	public void addInvoice(Invoice invoice) {
		invoice.setInvoiceId(invoiceId++);
		invoices.add(invoice);
	}
	public void posodobi(Invoice editInvoice) {
		
		for(int i=0; i<invoices.size();i++){
		if(editInvoice.getInvoiceId()==invoices.get(i).getInvoiceId()){
			invoices.set(i, editInvoice);
			System.out.println("Uspesna sprememba.");
			}
		}
	}
	public void removeInvoice(Invoice invoice){
		
		if(invoices.size()==1){
			this.invoices.remove(invoice);	
		invoiceId--;
		}
		else {
			for(int i=1;i<=invoices.size();i++){
				if(i>invoice.getInvoiceId()){
					invoices.get(i-1).setInvoiceId(i-1);
				}
			}
			invoiceId--;
			this.invoices.remove(invoice);
		}
		
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
}
