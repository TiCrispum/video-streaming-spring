package com.ticrispum.videostreamingspring;

import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.net.MalformedURLException;

@Component
public class VideoHandler {

    public Mono<ServerResponse> stream(ServerRequest request) {
        String videoLocation = "../videos";
        String videoName = "SampleVideo_1280x720_1mb.mp4";
        UrlResource video;

        String path = "file:%s/%s";
        path = String.format(path, videoLocation, videoName);
        try {
            video = new UrlResource(path);
        } catch (MalformedURLException e) {
            System.out.println("Exception");
            e.printStackTrace();
            return ServerResponse.status(500).build();
        }
        return ServerResponse.ok().contentType(MediaTypeFactory
                        .getMediaType(video)
                        .orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(BodyInserters.fromValue(video));
    }
}