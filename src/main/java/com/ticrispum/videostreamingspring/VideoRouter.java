package com.ticrispum.videostreamingspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class VideoRouter {

    @Bean
    public RouterFunction<ServerResponse> videoRoute(VideoHandler videoHandler) {

        return RouterFunctions
                .route(GET("/video").and(accept(MediaType.APPLICATION_JSON)), videoHandler::stream);
    }
}