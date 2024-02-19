package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.CreationTransactionService;
import com.bidi.transactions.domain.mapper.TransactionDtoMapper;
import com.bidi.transactions.domain.model.RequestCreateTransaction;
import com.bidi.transactions.domain.model.ResponseTransaction;
import com.bidi.transactions.domain.port.BalanceRest;
import com.bidi.transactions.domain.service.ServiceTransactionRepository;
import com.bidi.transactions.shared.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static com.bidi.transactions.application.utils.StringConstants.APPROVED;
import static com.bidi.transactions.application.utils.StringConstants.CANCELLED;
import static com.bidi.transactions.application.utils.StringConstants.ERROR;
import static com.bidi.transactions.application.utils.StringConstants.SUCCESSFULLY;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreationTransactionServiceImpl implements CreationTransactionService {

    private final ServiceTransactionRepository transactionRepository;
    private final BalanceRest balanceRest;
    private final TransactionDtoMapper transactionDtoMapper;

    @Override
    public ResponseTransaction createTransaction(
            RequestCreateTransaction request,
            String token) {
        log.info("Request is made...");
        try {
            MessageResponse response = balanceRest.makeRestToBalanceService(transactionDtoMapper.requestDomainToRequestInfrastructure(request), token);
            log.info("BalanceService response: {}", response.message());
            return transactionDtoMapper.daoToResponseDto(transactionRepository.save(
                    request,
                    APPROVED.getValue(),
                    setDescription(response.code())
            ));
        }catch (WebClientResponseException e) {
            log.error("Error: {}", e.getMessage());
            return transactionDtoMapper.daoToResponseDto(transactionRepository.save(
                    request,
                    CANCELLED.getValue(),
                    e.getMessage()
            ));
        }
    }

    public String setDescription(String statusCode) {
        return statusCode.equals("00") ? SUCCESSFULLY.getValue() : ERROR.getValue();
    }
}
