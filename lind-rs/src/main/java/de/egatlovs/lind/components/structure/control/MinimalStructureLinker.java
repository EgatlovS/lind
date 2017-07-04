package de.egatlovs.lind.components.structure.control;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.structure.entity.Structure;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.rest.StructureResourceDefinition;
import de.egatlovs.lind.shared.UriContext;

@RequestScoped
public class MinimalStructureLinker {

	@Inject
	private UriContext uriContext;

	public MinimalStructureDTO link(MinimalStructureDTO dto, Structure structure) {
		// self
		Link self = Link
				.fromUri(uriContext.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "getStructureById").build(structure.getId()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// remove by id
		Link removeStructureById = Link
				.fromUri(uriContext.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "removeStructureById").build(structure.getId()))
				.rel("remove").type("DELETE").build();
		dto.get_links().add(removeStructureById);

		// linkpoints
		Link linkpoints = Link
				.fromUri(uriContext.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "getLinkpointsByStructureId").build(structure.getId()))
				.rel("linkpoints").type("GET").build();
		dto.get_links().add(linkpoints);

		return dto;
	}

}
