package com.bidi.transactions.application.utils;

import lombok.Getter;

@Getter
public enum StringConstants {
    SUCCESSFULLY("Transaction successfully."),
    ERROR ("Error."),
    MESSAGE_INDEX_OF ("message"),
    APPROVED("Approved"),
    CANCELLED  ("Cancelled");
    private final String value;
    StringConstants(String value) {
        this.value = value;
    }
}
