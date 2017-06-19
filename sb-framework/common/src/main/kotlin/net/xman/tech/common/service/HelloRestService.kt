package net.xman.tech.common.service

import org.springframework.stereotype.Service
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/sayHello")
@Service
interface HelloRestService {

    @GET
    @Path("/{a}")
    @Produces(MediaType.TEXT_PLAIN)
    fun sayHello(@PathParam("a") a: String): String

}