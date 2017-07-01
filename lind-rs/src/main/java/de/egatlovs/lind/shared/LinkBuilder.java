package de.egatlovs.lind.shared;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;

import de.egatlovs.lind.components.linkpoint.entity.Field;
import de.egatlovs.lind.components.linkpoint.entity.Linkpoint;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.linkpoint.rest.LinkpointResourceDefinition;
import de.egatlovs.lind.components.structure.entity.Structure;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;
import de.egatlovs.lind.components.structure.rest.StructureResourceDefinition;

@SessionScoped
public class LinkBuilder implements Serializable {

	private static final long serialVersionUID = 1L;

	private UriBuilder builder;

	public LinkpointDTO build(Linkpoint linkpoint, LinkpointDTO dto) {
		// self
		Link self = Link
				.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "getLinkpointById").build(linkpoint.getId()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// structure by id
		Link structureById = Link.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
				.path(StructureResourceDefinition.class, "getStructureById").build(linkpoint.getParent().getId()))
				.rel("structure").type("GET").build();
		dto.get_links().add(structureById);

		// fields
		List<Field> fields = linkpoint.getFields();
		for (Field field : fields) {
			Link fieldLink = Link.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
					.path(LinkpointResourceDefinition.class, "getLinkpointField")
					.build(linkpoint.getId(), field.getName())).rel(field.getName()).type("GET").build();
			dto.get_links().add(fieldLink);
		}

		// update linkpoint
		Link updateLinkpoint = Link
				.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "updateLinkpointById").build(linkpoint.getId()))
				.rel("update").type("PUT").build();
		dto.get_links().add(updateLinkpoint);

		// remove linkpoint
		Link removeLinkpoint = Link
				.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "removeLinkpointById").build(linkpoint.getId()))
				.rel("remove").type("DELETE").build();
		dto.get_links().add(removeLinkpoint);

		for (FieldDTO fieldDto : dto.getFields()) {
			build(linkpoint, fieldDto);
		}

		return dto;
	}

	public FieldDTO build(Linkpoint linkpoint, FieldDTO dto) {
		// self
		Link self = Link.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
				.path(LinkpointResourceDefinition.class, "getLinkpointField").build(linkpoint.getId(), dto.getName()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// structure by id
		Link structureById = Link.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
				.path(StructureResourceDefinition.class, "getStructureById").build(linkpoint.getParent().getId()))
				.rel("structure").type("GET").build();
		dto.get_links().add(structureById);

		// linkpoint
		Link linkpointById = Link
				.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "getLinkpointById").build(linkpoint.getId()))
				.rel("linkpoint").type("GET").build();
		dto.get_links().add(linkpointById);

		return dto;
	}

	public MinimalStructureDTO build(MinimalStructureDTO dto, Structure structure) {
		// self
		Link self = Link
				.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "getStructureById").build(structure.getId()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// remove by id
		Link removeStructureById = Link
				.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "removeStructureById").build(structure.getId()))
				.rel("remove").type("DELETE").build();
		dto.get_links().add(removeStructureById);

		// linkpoints
		Link linkpoints = Link
				.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "getLinkpointsByStructureId").build(structure.getId()))
				.rel("linkpoints").type("GET").build();
		dto.get_links().add(linkpoints);

		return dto;
	}

	public StructureDTO build(StructureDTO dto, Structure structure) {
		// self
		Link self = Link
				.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "getStructureById").build(structure.getId()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// remove by id
		Link removeStructureById = Link
				.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "removeStructureById").build(structure.getId()))
				.rel("remove").type("DELETE").build();
		dto.get_links().add(removeStructureById);

		// linkpoints
		Link linkpoints = Link
				.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
						.path(StructureResourceDefinition.class, "getLinkpointsByStructureId").build(structure.getId()))
				.rel("linkpoints").type("GET").build();
		dto.get_links().add(linkpoints);
		return dto;
	}

	public MinimalLinkpointDTO build(MinimalLinkpointDTO dto, Linkpoint linkpoint) {
		// self
		Link self = Link
				.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "getLinkpointById").build(linkpoint.getId()))
				.rel("self").type("GET").build();
		dto.get_links().add(self);

		// structure by id
		Link structureById = Link.fromUri(this.getBuilder().path(StructureResourceDefinition.class)
				.path(StructureResourceDefinition.class, "getStructureById").build(linkpoint.getParent().getId()))
				.rel("structure").type("GET").build();
		dto.get_links().add(structureById);

		// fields
		List<Field> fields = linkpoint.getFields();
		for (Field field : fields) {
			Link fieldLink = Link.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
					.path(LinkpointResourceDefinition.class, "getLinkpointField")
					.build(linkpoint.getId(), field.getName())).rel(field.getName()).type("GET").build();
			dto.get_links().add(fieldLink);
		}

		// update linkpoint
		Link updateLinkpoint = Link
				.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "updateLinkpointById").build(linkpoint.getId()))
				.rel("update").type("PUT").build();
		dto.get_links().add(updateLinkpoint);

		// remove linkpoint
		Link removeLinkpoint = Link
				.fromUri(this.getBuilder().path(LinkpointResourceDefinition.class)
						.path(LinkpointResourceDefinition.class, "removeLinkpointById").build(linkpoint.getId()))
				.rel("remove").type("DELETE").build();
		dto.get_links().add(removeLinkpoint);

		return dto;
	}

	public UriBuilder getBuilder() {
		return builder.clone();
	}

	public void setBuilder(UriBuilder builder) {
		this.builder = builder;
	}

}
