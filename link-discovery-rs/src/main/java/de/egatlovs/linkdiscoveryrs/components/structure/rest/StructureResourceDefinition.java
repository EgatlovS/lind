package de.egatlovs.linkdiscoveryrs.components.structure.rest;

import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.structure.entity.StructureDTO;
import de.egatlovs.linkdiscoveryrs.rest.CustomMediaType;
import de.egatlovs.linkdiscoveryrs.rest.VersioningInterceptor;

@Interceptors(VersioningInterceptor.class)
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = CustomMediaType.VERSION_1_JSON)
@Path("/structures")
public interface StructureResourceDefinition {

	@GET
	public Response getStructures();

	@GET
	@Path("/{id}")
	public Response getStructureById(@PathParam("id") long id);

	@GET
	@Path("/{name}")
	public Response getStructureByName(@PathParam("name") String name);

	@POST
	@Path("/structure")
	public Response createStructure(StructureDTO structure);

	@DELETE
	@Path("/{id}")
	public Response removeStructureById(@PathParam("id") long id);

	@DELETE
	@Path("/{name}")
	public Response removeStructureByName(@PathParam("name") String name);

	@GET
	@Path("/{id}/links")
	public Response getLinkpointsByStructureId(@PathParam("id") long id);

}
