package de.egatlovs.linkdiscoveryrs.components.structure.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.LinkpointDTO;
import de.egatlovs.linkdiscoveryrs.components.structure.boundary.StructureBoundary;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDTO;

@RequestScoped
public class StructureResource implements StructureResourceDefinition {

	@Inject
	private StructureBoundary bdry;

	@Override
	public Response getStructures() {
		System.out.println(bdry);
		List<StructureDTO> structures = bdry.getStructures();
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
		StructureDTO created = bdry.createStructure(structure);
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
		List<LinkpointDTO> linkpoints = bdry.getLinkpointsByStructureId(id);
		return Response.ok(linkpoints).build();
	}

}
