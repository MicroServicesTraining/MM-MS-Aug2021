/**
 * 
 */
package com.ts.jpa.rel.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.jpa.rel.demo.entities.Subscription;
import com.ts.jpa.rel.demo.repositories.SubscriptionRepository;

/**
 * @author USER
 *
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public List<Subscription> fetchAllSubscriptions() {
		return subscriptionRepository.findAll();
	}

	@Override
	public Subscription addNewSubscription(Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}

}
