package de.egatlovs.lind.components.linkpoint.control;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.rest.LinkpointResourceDefinition;
import de.egatlovs.lind.components.structure.rest.StructureResourceDefinition;
import de.egatlovs.lind.shared.UriContext;

@RequestScoped
public class FieldLinker {

	@Inject
	private UriContext uriContext;

	public FieldDTO link(Linkpoint linkpoint, FieldDTO dto) {
		// self
		Link self = Link.fromUri(uriContext.getBuilder().path(LinkpointResourceDefinition.class)
				.path(LinkpointResourceDefinition.class, "getLinkpointField").build(linkpoint.getId(), dto.getName()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// structure by id
		Link structureById = Link.fromUri(uriContext.getBuilder().path(StructureResourceDefinition.class)
				.path(StructureResourceDefinition.class, "getStructureById").build(linkpoint.getParent().getId()))
				.rel("structure").type("GET").build();
		dto.get_links().add(structureById);

		// linkpoint
		Link linkpointById = Link
				.fromUri(uriContext.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "getLinkpointById").build(linkpoint.getId()))
				.rel("linkpoint").type("GET").build();
		dto.get_links().add(linkpointById);

		return dto;
	}

}
