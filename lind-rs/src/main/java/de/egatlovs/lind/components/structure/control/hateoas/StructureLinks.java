package de.egatlovs.lind.components.structure.control.hateoas;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.structure.entity.Structure;
import de.egatlovs.lind.shared.Hal;

@RequestScoped
public class StructureLinks {

	@Inject
	private Hal hal;

	public List<Link> links(Structure structure) {
		List<Link> links = new ArrayList<>();
		links.add(hal.structure(structure.getId(), "self", "GET"));
		links.add(hal.structure(structure.getId(), "remove", "DELETE"));
		links.add(hal.linkpointsByStructure(structure.getId(), "linkpoints", "GET"));
		return links;
	}

}
