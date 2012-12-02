package si.fri.wimm.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import si.fri.wimm.entity.Customer;

@Named
@SessionScoped
public class ListCustomerBean implements Serializable{
	
	private static final long serialVersionUID = -6267582727032162538L;

	@Inject
	private CustomerBean customerBean;
	
	private Customer selectedCustomer;
	
	private String name;
	private String surname;
	
	private boolean edit=false;
	
	public ListCustomerBean() {
		super();
		edit=false;
	}

	public boolean isEdit() {
		return edit;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public String getName() {
		return selectedCustomer.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return selectedCustomer.getSurname();
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public List<Customer> getAllCustomers() {
		return customerBean.getCustomers();
	}

	/**
	 * Update customer action
	 * @param event
	 */
	public void updateCustomer(ActionEvent event) {
		edit=true;
	}
	
	/**
	 * Save customer action
	 * @param event
	 */
	public void saveCustomer(ActionEvent event) {
		edit=false;
	
		Customer customer = new Customer();
		customer.setName(name);
		customer.setSurname(surname);
		
		customerBean.updateCustomer(customer, selectedCustomer.getId());
	}
}
