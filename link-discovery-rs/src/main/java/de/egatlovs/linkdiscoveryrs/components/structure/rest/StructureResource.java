package de.egatlovs.linkdiscoveryrs.components.structure.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.linkpoint.entity.Linkpoint;
import de.egatlovs.linkdiscoveryrs.components.structure.boundary.StructureBoundary;
import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;

public class StructureResource implements StructureResourceDefinition {

	@Inject
	private StructureBoundary bdry;

	@Override
	public Response getStructures() {
		List<Structure> structures = bdry.getStructures();
		return Response.ok(structures).build();
	}

	@Override
	public Response getStructureById(long id) {
		Structure structure = bdry.getStructureById(id);
		return Response.ok(structure).build();
	}

	@Override
	public Response getStructureByName(String name) {
		Structure structure = bdry.getStructureByName(name);
		return Response.ok(structure).build();
	}

	@Override
	public Response createStructure(Structure structure) {
		Structure created = bdry.createStructure(structure);
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
		List<Linkpoint> linkpoints = bdry.getLinkpointsByStructureId(id);
		return Response.ok(linkpoints).build();
	}

	@Override
	public Response removeLinkpointsByStructureId(long id) {
		bdry.removeLinkpointsByStructureId(id);
		return Response.ok().build();
	}

}
