package com.bidi.transactions.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.bidi.transactions.utils.StringConstants.MESSAGE_INDEX_OF;

@Component
@RequiredArgsConstructor
public class Util {
    private static final Random random = new Random();
    public static String extractRestResponse(String input) {
        return input.substring(input.indexOf(MESSAGE_INDEX_OF) + 9, input.length() - 2).replace("\"", "");
    }

    public static String generateReference() {
        return String.valueOf(random.nextInt(99999999 - 10000000 + 1) + 10000000);
    }
}
