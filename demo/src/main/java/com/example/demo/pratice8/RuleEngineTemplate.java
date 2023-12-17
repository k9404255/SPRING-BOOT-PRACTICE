package com.example.demo.pratice8;

import java.util.HashMap;
import java.util.Map;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.spel.SpELRule;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.BeanResolver;

import lombok.Data;

@Data
public class RuleEngineTemplate implements InitializingBean {
	@Autowired
	private ApplicationContext applicationContext;

	private RuleEngineConfigProperties properties;

	private RulesEngine rulesEngine;

	private BeanResolver beanResolver;

	private Map<String, Rules> rules = new HashMap<>();

	public void fire(String ruleId, Facts facts) {
		Rules rules = this.rules.get(ruleId);
		if (rules == null) {
			throw new RuntimeException("rule id: " + ruleId + "not define, please check");
		}
		rulesEngine.fire(rules, facts);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 根據demo-rule.yml的規則設定來創建規則
//		for (RuleEngineConfigProperties.RuleConfig ruleConfig : properties.getRules()) {
//			RuleDefinitionReader ruleDefinitionReader = new YamlRuleDefinitionReader();
//			SpELRuleFactory spELRuleFactory = new SpELRuleFactory(ruleDefinitionReader, beanResolver);
//			Rules rule = spELRuleFactory.createRules(
//					new InputStreamReader(ResourceUtils.getURL(ruleConfig.getRuleFileLocation()).openStream(),
//							StandardCharsets.UTF_8.displayName()));
//			rules.put(ruleConfig.getRuleId(), rule);
//		}

		Rules spelRules = new Rules();
		rules.put("alcohol", spelRules);
		SpELRule spELRule = new SpELRule();

		// rule 1
		spELRule.description("bean demo");
		spELRule.priority(1);
		spELRule.when("#{#person.getAdult() == false}");
		spELRule.then("#{T(java.lang.System).out.println(\"Shop1: Sorry, you are not allowed to buy alcohol\")}");
		spelRules.register(spELRule);

		// rule 2
		spELRule = new SpELRule();
		spELRule.description("bean demo");
		spELRule.priority(2);
		spELRule.when("#{#person.getAdult() == true}");
		spELRule.then("#{T(java.lang.System).out.println(\"Shop2: Sorry, you are not allowed to buy alcohol\")}");
		spelRules.register(spELRule);

		// rule 3
		spELRule = new SpELRule(new SimpleBeanResolver(applicationContext));
		spELRule.description("bean demo");
		spELRule.priority(3);
		spELRule.when("#{@MyService.isChild(#person)}");
		spELRule.then("#{@MyService.action(#person)}");
		spelRules.register(spELRule);
	}
}
