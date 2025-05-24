package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void test1_EveryStatement(){
        RuntimeException exception;

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, ""));
        assertTrue(exception.getMessage().contains("allItems list can't be null!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("", 1, 100, 0.0)), "0123456789123456"));
        assertTrue(exception.getMessage().contains("Invalid item!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Chair", 1, 100, 0.0)), "12345"));
        assertTrue(exception.getMessage().contains("Invalid card number!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Chair", 1, 100, 0.0)), "12345abcd1234efg"));
        assertTrue(exception.getMessage().contains("Invalid character in card number!"));

        assertEquals(690.0, SILab2.checkCart(List.of(new Item("Chair", 2, 400, 0.1)), "0123456789123456"));
    }

    @Test
    public void test2_MultipleCondition(){
        RuntimeException exception;

        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(
                new Item("Chair", 3, 400, 0.0),
                new Item("Chair", 1, 200, 0.15),
                new Item("Chair", 12, 50, 0.0),
                new Item("Chair", 5, 100, 0.0)), "cardNumberIgor"));

        assertTrue(exception.getMessage().contains("Invalid character in card number!"));
    }
}