package com.bidi.transactions.controller;

import com.bidi.transactions.dto.balance.CreateBalanceRequest;
import com.bidi.transactions.dto.balance.CreateBalanceResponse;
import com.bidi.transactions.dto.balance.UpdateProducerAndReceiverBalanceRequest;
import com.bidi.transactions.dto.balance.UpdateProducerBalanceRequest;
import com.bidi.transactions.service.balance.CreateBalanceService;
import com.bidi.transactions.service.balance.GetAllBalancesService;
import com.bidi.transactions.service.balance.GetBalanceByIdUserService;
import com.bidi.transactions.service.balance.UpdateProducerAndReceiverService;
import com.bidi.transactions.service.balance.UpdateProducerService;
import com.bidi.transactions.utils.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/balance")
public class BalanceController {

    private final GetAllBalancesService getAllBalancesService;
    private final GetBalanceByIdUserService getBalanceByIdUserService;
    private final CreateBalanceService createBalanceService;
    private final UpdateProducerAndReceiverService updateProducerAndReceiverService;
    private final UpdateProducerService updateProducerService;

    @GetMapping("/")
    public ResponseEntity< List<CreateBalanceResponse> > getAllBalancesService() {
        return new ResponseEntity<>(getAllBalancesService.getAllBalances(), HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<CreateBalanceResponse> getBalanceByIdUser (@PathVariable String idUser) throws Exception {
        return new ResponseEntity<>(getBalanceByIdUserService.getBalances(idUser), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<MessageResponse> createBalance (@RequestBody CreateBalanceRequest createBalanceRequest) {
        MessageResponse response = createBalanceService.createBalance(createBalanceRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<MessageResponse> updateProducerAndReceiverBalance(
            @RequestBody UpdateProducerAndReceiverBalanceRequest updateProducerAndReceiverBalanceRequest,
            @PathVariable String idUser) {

        MessageResponse response = updateProducerAndReceiverService.updateProducerAndReceiverBalance(
                updateProducerAndReceiverBalanceRequest,
                idUser
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/producer/{idUser}")
    public ResponseEntity<MessageResponse> updateProducerBalance(
            @RequestBody UpdateProducerBalanceRequest updateProducerBalanceRequest,
            @PathVariable String idUser) {

        MessageResponse response = updateProducerService.updateProducerBalance(updateProducerBalanceRequest, idUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
