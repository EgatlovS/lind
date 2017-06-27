package de.egatlovs.lind.components.structure.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.core.Response;

import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.boundary.StructureBoundary;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;
import de.egatlovs.lind.rest.VersioningInterceptor;

@Interceptors(VersioningInterceptor.class)
@RequestScoped
public class StructureResource implements StructureResourceDefinition {

	@Inject
	private StructureBoundary bdry;

	@Override
	public Response getStructures() {
		List<MinimalStructureDTO> structures = bdry.getStructures();
		return Response.ok(structures).build();
	}

	@Override
	public Response getStructureById(long id) {
		StructureDTO structure = bdry.getStructureById(id);
		return Response.ok(structure).build();
	}

	@Override
	public Response getStructureByName(String name) {
		StructureDTO structure = bdry.getStructureByName(name);
		return Response.ok(structure).build();
	}

	@Override
	public Response createStructure(StructureDTO structure) {
		MinimalStructureDTO created = bdry.createStructure(structure);
		return Response.status(201).entity(created).build();
	}

	@Override
	public Response removeStructureById(long id) {
		bdry.removeStructureById(id);
		return Response.ok().build();
	}

	@Override
	public Response removeStructureByName(String name) {
		bdry.removeStructureByName(name);
		return Response.ok().build();
	}

	@Override
	public Response getLinkpointsByStructureId(long id) {
		List<MinimalLinkpointDTO> linkpoints = bdry.getLinkpointsByStructureId(id);
		return Response.ok(linkpoints).build();
	}

}
