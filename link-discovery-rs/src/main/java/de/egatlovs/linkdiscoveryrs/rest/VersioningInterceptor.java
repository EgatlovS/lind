package de.egatlovs.linkdiscoveryrs.rest;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

public class VersioningInterceptor {

	@AroundInvoke
	public Response intercept(InvocationContext ctx) throws Exception {
		try {
			Object result = ctx.proceed();
			Response response = (Response) result;
			Object obj = ctx.getTarget();
			int version = CustomMediaType.getVersion(obj.getClass().getAnnotation(Consumes.class).value());
			return Response.fromResponse(response).header("x-api-version", version).build();
		} catch (Exception e) {
			throw new Exception("Couldnt attach version", e);
		}
	}

}
