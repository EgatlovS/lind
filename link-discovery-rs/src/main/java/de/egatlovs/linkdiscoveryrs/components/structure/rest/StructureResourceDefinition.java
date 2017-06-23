package de.egatlovs.linkdiscoveryrs.components.structure.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.structure.entity.Structure;

@Path("/v1/structures")
public interface StructureResourceDefinition {

	@GET
	public Response getStructures();
	
	@POST
	public Response createStructures(List<Structure> structures);
	
	@GET
	@Path("/{id}")
	public Response getStructureById(@PathParam("id") long id);
	
	@GET
	@Path("/{name}")
	public Response getStructureByName(@PathParam("name") String name);
	
	@POST
	@Path("/structure")
	public Response createStructure(Structure structure);
	
	@DELETE
	@Path("/{id}")
	public Response removeStructureById(@PathParam("id") long id);
	
	@DELETE
	@Path("/{name}")
	public Response removeStructureByName(@PathParam("name") String name);
	
}
