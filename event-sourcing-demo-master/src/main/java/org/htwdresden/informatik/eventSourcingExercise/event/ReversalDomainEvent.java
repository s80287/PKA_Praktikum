package org.htwdresden.informatik.eventSourcingExercise.event;

import java.time.LocalDate;

import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ReversalDomainEvent extends DomainEvent{
	private static final Logger log = LoggerFactory.getLogger(ReversalDomainEvent.class);

    public ReversalDomainEvent(LocalDate occuredDate) {
    	super(occuredDate);
    }
    
    public abstract void reverse();
}
