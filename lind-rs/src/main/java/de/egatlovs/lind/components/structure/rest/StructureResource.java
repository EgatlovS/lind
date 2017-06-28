package de.egatlovs.lind.components.structure.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.egatlovs.lind.components.linkpoint.entity.dto.MinimalLinkpointDTO;
import de.egatlovs.lind.components.structure.boundary.StructureBoundary;
import de.egatlovs.lind.components.structure.entity.dto.MinimalStructureDTO;
import de.egatlovs.lind.components.structure.entity.dto.StructureDTO;
import de.egatlovs.lind.rest.VersioningInterceptor;
import de.egatlovs.lind.shared.LinkBuilder;

@Interceptors(VersioningInterceptor.class)
@RequestScoped
public class StructureResource implements StructureResourceDefinition {

	@Context
	private UriInfo uriInfo;

	@Inject
	private StructureBoundary bdry;

	@Inject
	private LinkBuilder linkBuilder;

	@Override
	public Response getStructures() {
		linkBuilder.setBuilder(uriInfo.getBaseUriBuilder());
		List<MinimalStructureDTO> structures = bdry.getStructures();
		return Response.ok(structures).build();
	}

	@Override
	public Response getStructureById(long id) {
		StructureDTO structure = bdry.getStructureById(id);
		return Response.ok(structure).build();
	}

	@Override
	public Response createStructure(StructureDTO structure) {
		bdry.createStructure(structure);
		return Response.status(201).build();
	}

	@Override
	public Response removeStructureById(long id) {
		bdry.removeStructureById(id);
		return Response.ok().build();
	}

	@Override
	public Response getLinkpointsByStructureId(long id) {
		List<MinimalLinkpointDTO> linkpoints = bdry.getLinkpointsByStructureId(id);
		return Response.ok(linkpoints).build();
	}

}
