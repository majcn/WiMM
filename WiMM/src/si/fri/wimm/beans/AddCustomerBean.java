package si.fri.wimm.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import si.fri.wimm.entity.Customer;

@Named
@RequestScoped
public class AddCustomerBean {

	private String id;
	private String name;
	private String surname;
	
	@Inject
	CustomerBean customerBean;
	
	private Customer addedCustomer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Customer getAddedCustomer() {
		return addedCustomer;
	}

	/**
	 * Add Customer action
	 * @return
	 */
	public String addCustomer() {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setSurname(surname);
		
		this.addedCustomer=customer;
		customerBean.addCustomer(customer);
		System.out.println("S");
		return "addCustomerResult";
	}
}
