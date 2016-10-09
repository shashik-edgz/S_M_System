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
public class FinishedInfo {
    
	private String type_id;
	private String type;
	private Integer amount;
        
	
	public FinishedInfo(String type_id, String type, Integer amount)
	{
		super();
		
                this.setType_id(type_id);
                this.setType(type);
                this.setAmount(amount);
		
	}

    /**
     * @return the type_id
     */
    public String getType_id() {
        return type_id;
    }

    /**
     * @param type_id the type_id to set
     */
    public void setType_id(String type_id) {
        this.type_id = type_id;
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
    
}
