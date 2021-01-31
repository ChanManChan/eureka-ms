package com.u4.api.users.shared;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

// FeignErrorDecoder <- make it available as bean
@Component //<- when spring framework scans the classes looking for annotations like Service, Entity or Repository or
// Component, it will create an instance of FeignErrorDecoder class so that we do not have to create FeignErrorDecoder ourselves.
// go to main file and comment out the @Bean code.
public class FeignErrorDecoder implements ErrorDecoder {

    Environment environment;

    @Autowired
    public FeignErrorDecoder(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 400:
                // return new BadRequestException();
                break;
            case 404:
                if(s.contains("getAlbums")) {
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()), environment.getProperty("albums.exceptions.albums-not-found"));
                }
                break;
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}
