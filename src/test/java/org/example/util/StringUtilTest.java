package org.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    public void TestRepeat(){
        Assertions.assertEquals("holaholahola", StringUtil.repeat("hola",3));
        Assertions.assertEquals("hola", StringUtil.repeat("hola",1));
    }
}

