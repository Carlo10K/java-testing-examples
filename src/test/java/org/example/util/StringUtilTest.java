package org.example.util;

import org.junit.jupiter.api.Assertions;

class StringUtilTest {
    public static void main(String[] args) {
        Assertions.assertEquals("holaholahola", StringUtil.repeat("hola",3));
        Assertions.assertEquals("hola", StringUtil.repeat("hola",1));
    }
}