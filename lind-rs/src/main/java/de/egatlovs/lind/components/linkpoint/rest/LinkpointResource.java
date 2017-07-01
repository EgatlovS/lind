package de.egatlovs.lind.components.linkpoint.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.egatlovs.lind.components.linkpoint.boundary.LinkpointBoundary;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.rest.VersioningInterceptor;
import de.egatlovs.lind.shared.LinkBuilder;

@Interceptors(VersioningInterceptor.class)
@RequestScoped
public class LinkpointResource implements LinkpointResourceDefinition {

	@Inject
	private LinkpointBoundary bdry;

	@Context
	private UriInfo uriInfo;

	@Inject
	private LinkBuilder linkBuilder;

	@Override
	public Response getLinkpointById(long id) {
		linkBuilder.setBuilder(uriInfo.getBaseUriBuilder());
		LinkpointDTO linkpoint = bdry.getLinkpointById(id);
		return Response.ok(linkpoint).build();
	}

	@Override
	public Response createLinkpoint(LinkpointDTO linkpointDTO) {
		bdry.createLinkpoint(linkpointDTO);
		return Response.status(201).build();
	}

	@Override
	public Response updateLinkpointById(long id, LinkpointDTO linkpointDTO) {
		bdry.updateLinkpointById(id, linkpointDTO);
		return Response.ok().build();
	}

	@Override
	public Response removeLinkpointById(long id) {
		bdry.removeLinkpointById(id);
		return Response.ok().build();
	}

	@Override
	public Response getLinkpointField(long id, String fieldname) {
		linkBuilder.setBuilder(uriInfo.getBaseUriBuilder());
		FieldDTO field = bdry.getLinkpointField(id, fieldname);
		return Response.ok(field).build();
	}

}
