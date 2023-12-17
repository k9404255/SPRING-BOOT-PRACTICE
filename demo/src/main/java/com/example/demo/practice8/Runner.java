package com.example.demo.practice8;

import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
	@Autowired
	RuleEngineTemplate ruleEngineTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Person person = new Person();
		Facts facts = new Facts();
		facts.put("person", person);
		ruleEngineTemplate.fire("alcohol", facts);
	}

}
