/**
 * 
 */
package com.ts.jpa.rel.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author USER
 *
 */
@Entity
@Table(name = "subscriptions")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long subscriptionId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "fee")
	private Double fee;
	
	@Column(name = "type")
	private String type;

	
	
	/**
	 * 
	 */
	public Subscription() {
	}

	/**
	 * @param subscriptionId
	 * @param name
	 * @param fee
	 * @param type
	 */
	public Subscription(Long subscriptionId, String name, Double fee, String type) {
		this.subscriptionId = subscriptionId;
		this.name = name;
		this.fee = fee;
		this.type = type;
	}

	/**
	 * @param subscriptionId
	 */
	public Subscription(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	/**
	 * @return the subscriptionId
	 */
	public Long getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the fee
	 */
	public Double getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(Double fee) {
		this.fee = fee;
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
	
}
