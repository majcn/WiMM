package si.fri.wimm.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import si.fri.wimm.entity.Customer;

@Named
@SessionScoped
public class CustomerBean implements Serializable{
	
	private static final long serialVersionUID = -1872508599341374153L;

	private List<Customer> customers;
	
	private int id;
	
	public CustomerBean() {
		id=1;
		customers = new ArrayList<Customer>();
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * Add Customer
	 * @param c
	 */
	public void addCustomer(Customer c) {
		c.setId(id++);
		customers.add(c);
	}
	
	/**
	 * Return specific customer
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(int id) {
		for (Customer c : customers) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Update customer
	 * @param updateCustomer
	 * @param id
	 */
	public void updateCustomer(Customer updateCustomer, int id) {
		for (Customer c : customers) {
			if (c.getId() == id) {
				c.setName(updateCustomer.getName());
				c.setSurname(updateCustomer.getSurname());
			}
		}
	}
	
	/**
	 * Delete customer by id
	 * @param customer
	 */
	public void deleteCustomer(int customerId) {
		
		for (Customer c : customers) {
			if (c.getId()==customerId) {
				customers.remove(c);
				break;
			}
		}
	}
}
