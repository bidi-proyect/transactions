package com.bidi.transactions.dto.balance;

import lombok.Data;

@Data
public class CreateBalanceRequest {
    private String idUser;
    private long balance;
    private String phoneNumber;
}
