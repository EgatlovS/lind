package de.egatlovs.lind.components.linkpoint.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.rest.CustomMediaType;

@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = CustomMediaType.VERSION_1_JSON)
@Path("/links")
public interface LinkpointResourceDefinition {

	@GET
	@Path("/{id}")
	Response getLinkpointById(@PathParam("id") long id);

	@POST
	@Path("/link")
	Response createLinkpoint(LinkpointDTO linkpointDTO);

	@PUT
	@Path("/{id}")
	Response updateLinkpointById(@PathParam("id") long id, LinkpointDTO linkpointDTO);

	@DELETE
	@Path("/{id}")
	Response removeLinkpointById(@PathParam("id") long id);

	@GET
	@Path("/{id}/{fieldname}")
	Response getLinkpointField(@PathParam("id") long id, @PathParam("fieldname") String fieldname);

}
