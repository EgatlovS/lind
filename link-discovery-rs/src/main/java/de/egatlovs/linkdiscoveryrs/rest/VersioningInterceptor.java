package de.egatlovs.linkdiscoveryrs.rest;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

public class VersioningInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		Object result = ctx.proceed();
		Response response = (Response) result;
		Object obj = ctx.getTarget();
		Class<?>[] clazzes = obj.getClass().getInterfaces();
		for (Class<?> clazz : clazzes) {
			if (clazz.isAnnotationPresent(Consumes.class)) {
				int version = CustomMediaType.getVersion(clazz.getAnnotation(Consumes.class).value());
				return Response.fromResponse(response).header("x-api-version", version).build();
			}
		}
		throw new Exception("Couldnt attach version");
	}

}
