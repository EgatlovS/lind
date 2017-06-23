package de.egatlovs.linkdiscoveryrs.components.link.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import de.egatlovs.linkdiscoveryrs.components.link.entity.Link;

@Path("/v1/links")
public interface LinkResourceDefinition {

	@GET
	public Response getLinks(@QueryParam("structureId") long structureId, @QueryParam("structureName") String structureName);

	@POST
	public Response createLinks(List<Link> structures);

	@GET
	@Path("/{id}")
	public Response getLinkById(@PathParam("id") long id);

	@PUT
	@Path("/{id}")
	public Response updateLinkById(@PathParam("id") long id);

	@POST
	@Path("/link")
	public Response createLink(Link structure);

	@DELETE
	@Path("/{id}")
	public Response removeLinkById(@PathParam("id") long id);

	@DELETE
	public Response removeLinksByStructureId(@QueryParam("structureId") long structureId, @QueryParam("structureName") String structureName);

	@GET
	@Path("/{id}/{fieldname}")
	public Response getLinkField(@PathParam("id") long id, @PathParam("fieldname") String fieldname);
	
}
