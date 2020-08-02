package com.talend.se.platform.camel.example.component_configuration;

import java.util.SortedMap;

import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.ComponentConfiguration;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.ParameterConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentConfigurationMain {

	private static Logger logger = LoggerFactory.getLogger(ComponentConfigurationMain.class);


	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		CamelContext camelContext = new DefaultCamelContext();
		Component sedaComponent = camelContext.getComponent("seda");
		ComponentConfiguration sedaConfiguration = sedaComponent.createComponentConfiguration();

		// now lets introspect the available parameters...
		SortedMap<String, ParameterConfiguration> parameterMap = sedaConfiguration.getParameterConfigurationMap();
		
		String jsonSchema = sedaConfiguration.createParameterJsonSchema();
		logger.info(jsonSchema);
	}
	
}
