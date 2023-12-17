package com.example.demo.practice8;

import org.springframework.context.ApplicationContext;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

public class SimpleBeanResolver implements BeanResolver {
	private ApplicationContext applicationContext;

	public SimpleBeanResolver(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public Object resolve(EvaluationContext context, String beanName) {
		return applicationContext.getBean(beanName);
	}
}
