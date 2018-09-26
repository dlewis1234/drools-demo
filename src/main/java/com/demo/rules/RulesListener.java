package com.demo.rules;

import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RulesListener extends DefaultAgendaEventListener {
	Logger logger = LoggerFactory.getLogger(RulesListener.class);
	
	
	
	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		Rule rule = event.getMatch().getRule();
		logger.info(String.format("Rule Fired: %s", rule.getName()));
	}

}
