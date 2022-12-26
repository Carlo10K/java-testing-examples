package org.example.javatests.util;

import org.junit.jupiter.api.Assertions;
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
}

