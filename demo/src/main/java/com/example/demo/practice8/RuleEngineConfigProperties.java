package com.example.demo.practice8;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "rule")
public class RuleEngineConfigProperties {
	private boolean skipOnFirstAppliedRule = false;
	private boolean skipOnFirstFailedRule = false;
	private boolean skipOnFirstNonTriggeredRule = false;
	private List<RuleConfig> rules;

	@Data
	public static class RuleConfig {
		private String ruleId;
		private String ruleFileLocation;
	}
}