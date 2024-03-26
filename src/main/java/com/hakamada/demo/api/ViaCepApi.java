package com.hakamada.demo.api;

import com.hakamada.demo.api.codec.ExceptionMapper;
import com.hakamada.demo.api.exception.ViaCepApiRetryException;
import com.hakamada.demo.api.response.ViaCepResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ws")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "viacep-api")
@RegisterProvider(ExceptionMapper.class)
public interface ViaCepApi {


    @GET
    @Path("/{cep}/json")
    @Retry(maxRetries = 2, delay = 5000, retryOn = {ViaCepApiRetryException.class})
    ViaCepResponse getEndereco(@PathParam("cep") String cep);


}
