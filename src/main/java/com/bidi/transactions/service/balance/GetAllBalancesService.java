package com.bidi.transactions.service.balance;

import com.bidi.transactions.dto.balance.CreateBalanceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetAllBalancesService {
    List<CreateBalanceResponse> getAllBalances();
}
