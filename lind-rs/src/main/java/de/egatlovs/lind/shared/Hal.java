package de.egatlovs.lind.shared;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.linkpoint.rest.LinkpointResourceDefinition;
import de.egatlovs.lind.components.structure.rest.StructureResourceDefinition;

@RequestScoped
public class Hal {

	@Inject
	private UriContext uriContext;

	public Link linkpoint(long id, String rel, String type) {
		return link(LinkpointResourceDefinition.class, "getLinkpointById", rel, type, id);
	}

	public Link structure(long id, String rel, String type) {
		return link(StructureResourceDefinition.class, "getStructureById", rel, type, id);
	}

	public Link field(long linkpointId, String fieldname, String rel, String type) {
		return link(LinkpointResourceDefinition.class, "getLinkpointField", rel, type, linkpointId, fieldname);
	}

	public Link linkpointsByStructure(long id, String rel, String type) {
		return link(StructureResourceDefinition.class, "getLinkpointsByStructureId", rel, type, id);
	}

	private Link link(Class<?> clazz, String method, String rel, String type, Object... params) {
		return Link.fromUri(uriContext.getBuilder().path(clazz).path(clazz, method).build(params)).rel(rel).type(type)
				.build();
	}

}
