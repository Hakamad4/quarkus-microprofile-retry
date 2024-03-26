package com.hakamada.demo.api;

import com.hakamada.demo.api.response.ViaCepResponse;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URI;
import java.util.concurrent.TimeUnit;

public class ViaCepClient implements ViaCepApi{


    private static final String URL = "https://viacep.com.br/ws/";

    private ViaCepApi getClient() {
        return RestClientBuilder.newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .baseUri(URI.create(URL))
                .build(ViaCepApi.class);
    }

    @Override
    public ViaCepResponse getEndereco(String cep) {
        return getClient().getEndereco(cep);
    }
}
