package de.egatlovs.lind.components.linkpoint.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Link;

import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.linkpoint.rest.LinkpointResourceDefinition;
import de.egatlovs.lind.components.structure.rest.StructureResourceDefinition;
import de.egatlovs.lind.shared.UriContext;

@RequestScoped
public class MinimalLinkpointLinker {

	@Inject
	private UriContext uriContext;

	public MinimalLinkpointDTO link(MinimalLinkpointDTO dto, Linkpoint linkpoint) {
		// self
		Link self = Link
				.fromUri(uriContext.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "getLinkpointById").build(linkpoint.getId()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// structure by id
		Link structureById = Link.fromUri(uriContext.getBuilder().path(StructureResourceDefinition.class)
				.path(StructureResourceDefinition.class, "getStructureById").build(linkpoint.getParent().getId()))
				.rel("structure").type("GET").build();
		dto.get_links().add(structureById);

		// fields
		List<Field> fields = linkpoint.getFields();
		for (Field field : fields) {
			Link fieldLink = Link.fromUri(uriContext.getBuilder().path(LinkpointResourceDefinition.class)
					.path(LinkpointResourceDefinition.class, "getLinkpointField")
					.build(linkpoint.getId(), field.getName())).rel(field.getName()).type("GET").build();
			dto.get_links().add(fieldLink);
		}

		// update linkpoint
		Link updateLinkpoint = Link
				.fromUri(uriContext.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "updateLinkpointById").build(linkpoint.getId()))
				.rel("update").type("PUT").build();
		dto.get_links().add(updateLinkpoint);

		// remove linkpoint
		Link removeLinkpoint = Link
				.fromUri(uriContext.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "removeLinkpointById").build(linkpoint.getId()))
				.rel("remove").type("DELETE").build();
		dto.get_links().add(removeLinkpoint);

		return dto;
	}

}
