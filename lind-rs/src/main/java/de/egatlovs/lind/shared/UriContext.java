package de.egatlovs.lind.shared;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.UriBuilder;

@SessionScoped
public class UriContext implements Serializable {

	private static final long serialVersionUID = 1L;
	private UriBuilder builder;

	public UriBuilder getBuilder() {
		return builder.clone();
	}

	public void setBuilder(UriBuilder builder) {
		this.builder = builder;
	}

}
