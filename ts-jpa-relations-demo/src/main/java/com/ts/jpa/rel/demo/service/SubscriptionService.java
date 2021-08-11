/**
 * 
 */
package com.ts.jpa.rel.demo.service;

import java.util.List;

import com.ts.jpa.rel.demo.entities.Subscription;

/**
 * @author USER
 *
 */
public interface SubscriptionService {
	
	List<Subscription> fetchAllSubscriptions();
	
	Subscription addNewSubscription(Subscription subscription);
	
}
