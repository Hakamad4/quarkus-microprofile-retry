package com.hakamada.demo.api.codec;

import com.hakamada.demo.api.exception.ViaCepApiRetryException;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class ExceptionMapper implements ResponseExceptionMapper<ViaCepApiRetryException> {
    @Override
    public ViaCepApiRetryException toThrowable(Response response) {
        System.out.println("Simulando falha para status 200");
        if (response.getStatus() == 200) {
            return new ViaCepApiRetryException("Exemplo de retry.");
        }
        return null;
    }

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        return status >= 200;
    }
}
