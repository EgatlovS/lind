package de.egatlovs.lind.shared;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class PropertyLoader {

	public Properties read(String uri) {
		InputStream propertyFile = PropertyLoader.class.getClassLoader().getResourceAsStream(uri);
		Properties properties = new Properties();
		try {
			properties.load(propertyFile);
		} catch (IOException e) {
			// TODO Exception
		}
		return properties;
	}

}