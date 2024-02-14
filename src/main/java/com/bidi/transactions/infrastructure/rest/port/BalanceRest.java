package com.bidi.transactions.infrastructure.rest.port;

import com.bidi.transactions.application.utils.MessageResponse;
import com.bidi.transactions.dto.CreateTransactionRequest;
import com.bidi.transactions.dto.UpdateBalanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class BalanceRest {

    private RestTemplate restTemplate;
    @Value("${balance.url.base}")
    private String urlBase;
    @Value("${balance.url.one}")
    private String createPathOne;

    public ResponseEntity<MessageResponse> makeRestToBalanceService(
            CreateTransactionRequest createTransactionRequest,
            String token) {
        String url = urlBase + createPathOne + createTransactionRequest.getUserId();
        return this.restTemplate.exchange(url, HttpMethod.PUT, setHttpEntity(createTransactionRequest, token), MessageResponse.class);
    }

    public HttpEntity<UpdateBalanceRequest> setHttpEntity(
            CreateTransactionRequest createTransactionRequest,
            String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        return new HttpEntity<>(constructBalanceRequest(createTransactionRequest), headers);
    }

    public UpdateBalanceRequest constructBalanceRequest(CreateTransactionRequest createTransactionRequest) {
        UpdateBalanceRequest request = new UpdateBalanceRequest();
        request.setAmount(createTransactionRequest.getAmount());
        request.setPhoneProducer(createTransactionRequest.getPhoneProducer());
        request.setPhoneReceiver(createTransactionRequest.getPhoneReceiver());
        return request;
    }

    public String extractRestResponse(String input) {
        return input.substring(input.indexOf("message") + 9, input.length() - 2).replace("\"", "");
    }

}
