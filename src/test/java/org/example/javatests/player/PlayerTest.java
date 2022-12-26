package org.example.javatests.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void loosesWhenDiceNumberIsTooLow() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 3);
        assertFalse(player.play());
    }

    @Test
    void winWhenDiceNumberIsBig() {
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 3);
        assertTrue(player.play());
    }
}