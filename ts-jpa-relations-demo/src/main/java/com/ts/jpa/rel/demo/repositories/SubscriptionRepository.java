/**
 * 
 */
package com.ts.jpa.rel.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.jpa.rel.demo.entities.Subscription;

/**
 * @author USER
 *
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

}
