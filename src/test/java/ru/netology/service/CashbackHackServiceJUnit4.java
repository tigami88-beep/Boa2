package ru.netology.service;

import org.junit.Assert;
import org.junit.Test;

public class CashbackHackServiceJUnit4 {

    @Test
    public void testRemainWhenAmountIsZero() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(0);
        Assert.assertEquals("Для 0 рублей нужно докупить 1000", 1000, result);
    }

    @Test
    public void testRemainWhenAmountIsMultipleOfBoundary() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(1000);
        Assert.assertEquals("При сумме 1000 нужно докупить ещё 1000 для следующего порога", 1000, result);
    }

    @Test
    public void testRemainWhenAmountIsLessThanBoundary() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(900);
        Assert.assertEquals("Для 900 рублей нужно докупить 100", 100, result);
    }

    @Test
    public void testRemainWhenAmountIsMoreThanBoundary() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(1200);
        Assert.assertEquals("Для 1200 рублей нужно докупить 800", 800, result);
    }
}