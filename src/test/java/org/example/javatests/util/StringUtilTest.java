package org.example.javatests.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    public void repeatStringOnce(){
        Assertions.assertEquals("hola", StringUtil.repeat("hola",1));
    }

    @Test
    public void repeatStringMultipleTimes(){
        Assertions.assertEquals("holaholahola", StringUtil.repeat("hola",3));
    }

    @Test
    public void repeatZeroTimes(){
        Assertions.assertEquals("", StringUtil.repeat("hola",0));
    }

    @Test
    public void repeatStringNegativeTimes(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            StringUtil.repeat("hola",-1);
        });
    }

    @Test
    @DisplayName("when string is not empty")
    public void whenIsNotEmpty() {Assertions.assertFalse(StringUtil.isEmpty("a"));}

    @Test
    @DisplayName("when string is two quotes")
    public void whenEmptyQuot() { Assertions.assertTrue(StringUtil.isEmpty(""));}

    @Test
    @DisplayName("when string is null")
    public void whenIsNull() { Assertions.assertTrue(StringUtil.isEmpty(null));}

    @Test
    @DisplayName("when string is an space")
    public void whenIsSpaces() { Assertions.assertTrue(StringUtil.isEmpty(" ")); }
}

