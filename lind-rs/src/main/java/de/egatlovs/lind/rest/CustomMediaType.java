package de.egatlovs.lind.rest;

import javax.ws.rs.core.MediaType;

public class CustomMediaType {

	public final static String VERSION_1_JSON = "application/vnd.egatlovs.v1+json";
	public final static MediaType VERSION_1_JSON_TYPE = new MediaType("application", "vnd.egatlovs.v1+json");

	public static int getVersion(String[] value) {
		switch (value[0]) {
		case VERSION_1_JSON:
			return 1;
		default:
			return 0;
		}
	}

}
