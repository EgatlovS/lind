package de.egatlovs.lind.rest;

import de.egatlovs.lind.shared.PropertyLoader;

public class CorsConfig {

	private PropertyLoader propertyLoader;

	public CorsConfig() {
		this.propertyLoader = new PropertyLoader();
	}

	private static final String CORS_CONFIG = "config/cors-config.properties";

	public String origins() {
		return propertyLoader.read(CORS_CONFIG).getProperty("origins");
	}
}
