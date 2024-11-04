package com.sbigeneral.PINS.Entity;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;
@Component
public class CustomeIdGenerator implements IdentifierGenerator {
	private AtomicLong sequence= new AtomicLong(0);

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		long nextId=sequence.incrementAndGet();
		
		return "SBIG@0"+nextId;
	}

}
