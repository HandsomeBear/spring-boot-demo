package com.example.demo.analyzer;

import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * it is mandatory to register it in a standard resources/META-INF/spring.factories file that 
 * contains the org.springframework.boot.diagnostics.FailureAnalyzer key with a value of the full name of our class
 * e.g.  org.springframework.boot.diagnostics.FailureAnalyzer=\com.example.demo.analyzer.MyBeanNotOfRequiredTypeFailureAnalyzer
 * @author sunhao
 */
public class MyBeanNotOfRequiredTypeFailureAnalyzer
			extends AbstractFailureAnalyzer<BeanNotOfRequiredTypeException>{

	@Override
	protected FailureAnalysis analyze(Throwable rootFailure, BeanNotOfRequiredTypeException cause) {
		return new FailureAnalysis(getDescription(cause), getAction(cause), cause);
	}

	private String getDescription(BeanNotOfRequiredTypeException ex) {
        return String.format("The bean %s could not be injected as %s "
          + "because it is of type %s",
          ex.getBeanName(),
          ex.getRequiredType().getName(),
          ex.getActualType().getName());
    }
 
    private String getAction(BeanNotOfRequiredTypeException ex) {
        return String.format("Consider creating a bean with name %s of type %s",
          ex.getBeanName(),
          ex.getRequiredType().getName());
    }
}
