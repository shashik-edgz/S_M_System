/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_m_system;

/**
 *
 * @author Shashiki
 */
public class SaleInfo {
    	private Integer customer_id;
	private String customer;
	private String type;
        private Integer amount;
	private Double price;
        
	
	public SaleInfo(Integer customer_id, String customer, String type,Integer amount,Double price )
	{
		super();
		this.customer_id = customer_id;
		this.customer = customer;
		this.type = type;
                this.amount = amount;
		this.price = price;
	}

    /**
     * @return the customer_id
     */
    public Integer getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

	
	
    
}
