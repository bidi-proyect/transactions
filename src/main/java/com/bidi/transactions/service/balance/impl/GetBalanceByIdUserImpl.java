package com.bidi.transactions.service.balance.impl;

import com.bidi.transactions.dto.balance.CreateBalanceResponse;
import com.bidi.transactions.entity.Balance;
import com.bidi.transactions.repository.BalanceRepository;
import com.bidi.transactions.service.balance.GetBalanceByIdUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBalanceByIdUserImpl implements GetBalanceByIdUserService {

    private final BalanceRepository balanceRepository;
    @Override
    public CreateBalanceResponse getBalances(String idUser) throws Exception {
        Balance balance = balanceRepository.findBalanceByIdUser(idUser);
        if (balance == null) {
            throw new Exception("Balance not exists.");
        }
        return balanceToResponse(balance);
    }

    public CreateBalanceResponse balanceToResponse(Balance balance) {
        CreateBalanceResponse response = new CreateBalanceResponse();

        response.setIdBalance(balance.getIdBalance());
        response.setIdUser(balance.getIdUser());
        response.setBalance(balance.getBalance());
        response.setPhoneNumber(balance.getPhoneNumber());
        response.setCreationDate(balance.getCreationDate());
        response.setUpdateDate(balance.getUpdateDate());
        return response;
    }
}
