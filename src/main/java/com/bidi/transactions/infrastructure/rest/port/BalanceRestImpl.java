package com.bidi.transactions.infrastructure.rest.port;

import com.bidi.transactions.application.exceptions.TransactionException;
import com.bidi.transactions.domain.port.BalanceRest;
import com.bidi.transactions.infrastructure.rest.dto.request.CreateTransactionRequest;
import com.bidi.transactions.shared.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@RequiredArgsConstructor
@Component
@Log4j2
public class BalanceRestImpl implements BalanceRest {

    @Value("${balance.url.base}")
    private String urlBase;
    @Value("${balance.url.create}")
    private String createPathCreate;

    @Override
    public MessageResponse makeRestToBalanceService(
            CreateTransactionRequest request,
            String token) {

        return WebClient.create(urlBase.concat(createPathCreate.concat(request.userId())))
                .put()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, token)
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(MessageResponse.class)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    log.error("ResponseBody: ", ex.getResponseBodyAsString());
                    log.error("Error making operation makeRestToBalanceService: " + ex.getMessage());
                    return new TransactionException(ex.getMessage(), ex.getStatusCode());
                })
                .block();

    }

}
