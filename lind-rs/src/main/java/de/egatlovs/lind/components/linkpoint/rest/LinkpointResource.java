package de.egatlovs.lind.components.linkpoint.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.core.Response;

import de.egatlovs.lind.components.linkpoint.boundary.LinkpointBoundary;
import de.egatlovs.lind.components.linkpoint.entity.dto.FieldDTO;
import de.egatlovs.lind.components.linkpoint.entity.dto.LinkpointDTO;
import de.egatlovs.lind.rest.VersioningInterceptor;

@Interceptors(VersioningInterceptor.class)
@RequestScoped
public class LinkpointResource implements LinkpointResourceDefinition {

	@Inject
	private LinkpointBoundary bdry;

	@Override
	public Response getLinkpointById(long id) {
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
		FieldDTO field = bdry.getLinkpointField(id, fieldname);
		return Response.ok(field).build();
	}

}
