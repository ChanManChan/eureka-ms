package com.u4.api.users.data;

import com.u4.api.users.ui.model.AlbumResponseModel;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "albums-ws", fallback = AlbumsFallback.class) //<-- name = name of the web service that this feign client will communicate with
public interface AlbumsServiceClient {

    @GetMapping("/users/{id}/albums")
    public List<AlbumResponseModel> getAlbums(@PathVariable String id);
}

@Component
class AlbumsFallback implements AlbumsServiceClient {

    @Override
    public List<AlbumResponseModel> getAlbums(String id) {
        // called when the albums micro service is down
        return new ArrayList<>();
    }
}

//@Component
//class AlbumsFallbackFactory implements FallbackFactory<AlbumsServiceClient> {
//
//    @Override
//    public AlbumsServiceClient create(Throwable cause) {
//        return new AlbumsServiceClientFallback(cause);
//    }
//}
//
//class AlbumsServiceClientFallback implements AlbumsServiceClient {
//
//    Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    private final Throwable cause;
//
//    public AlbumsServiceClientFallback(Throwable cause) {
//        this.cause = cause;
//    }
//
//    @Override
//    public List<AlbumResponseModel> getAlbums(String id) {
//
//        if(cause instanceof FeignException && ((FeignException) cause).status() == 404) {
//            logger.error("404 error took place when getAlbums was called with userId: " + id + ". Error message: " + cause.getLocalizedMessage());
//        } else {
//            logger.error("Other error took place: " + cause.getLocalizedMessage());
//        }
//
//        return new ArrayList<>();
//    }
//}


