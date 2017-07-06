package de.egatlovs.lind.components.linkpoint.control.hateoas;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.shared.Hal;

@RequestScoped
public class LinkpointLinks {

	@Inject
	private Hal hal;

	public List<Link> links(Linkpoint linkpoint) {
		List<Link> links = new ArrayList<>();
		links.add(hal.linkpoint(linkpoint.getId(), "self", "GET"));
		links.add(hal.structure(linkpoint.getParent().getId(), "structure", "GET"));
		for (Field field : linkpoint.getFields()) {
			links.add(hal.field(linkpoint.getId(), field.getName(), field.getName(), "GET"));
		}
		links.add(hal.linkpoint(linkpoint.getId(), "update", "PUT"));
		links.add(hal.linkpoint(linkpoint.getId(), "remove", "DELETE"));
		return links;
	}

}
