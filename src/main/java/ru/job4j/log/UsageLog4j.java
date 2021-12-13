package ru.job4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class);

    public static void main(String[] args) {
        byte b = 127;
        short sh = 32767;
        int i = 32767327;
        long l = 327673276;
        float f = 327.67f;
        double d = 32.7673276d;
        boolean bool = true;
        char c = 'c';

        LOG.debug("Info - b - byte : {}, sh - short : {}, i - int : {}, "
                       + "l - long : {}, f - float : {}, d - double : {} bool - boolean : {}, c - char : {}",
                b, sh, i, l, f, d, bool, c);

    }
}
