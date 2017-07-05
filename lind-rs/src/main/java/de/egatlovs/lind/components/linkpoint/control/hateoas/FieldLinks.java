package de.egatlovs.lind.components.linkpoint.control.hateoas;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.shared.Hal;

@RequestScoped
public class FieldLinks {

	@Inject
	private Hal hal;

	public List<Link> links(Linkpoint linkpoint, FieldDTO dto) {
		List<Link> links = new ArrayList<>();
		links.add(hal.field(linkpoint.getId(), dto.getName(), "self", "GET"));
		links.add(hal.structure(linkpoint.getParent().getId(), "structure", "GET"));
		links.add(hal.linkpoint(linkpoint.getId(), "linkpoint", "GET"));
		return links;
	}

}
