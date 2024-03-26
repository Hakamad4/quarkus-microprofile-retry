package com.hakamada.demo.resource;

import com.hakamada.demo.api.ViaCepClient;
import com.hakamada.demo.api.response.ViaCepResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/viacep")
public class DemoResource {

    private final ViaCepClient viaCepClient;

    public DemoResource() {
        this.viaCepClient = new ViaCepClient();
    }

    @GET
    @Path("/cep/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ViaCepResponse viaCep(@PathParam("cep") String cep) {
        return viaCepClient.getEndereco(cep);
    }

}
