package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CashbackHackServiceTestNG {

    @Test
    public void testRemainWhenAmountIsZero() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(0);
        Assert.assertEquals(result, 1000, "Для 0 рублей нужно докупить 1000");
    }

    @Test
    public void testRemainWhenAmountIsMultipleOfBoundary() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(1000);
        Assert.assertEquals(result, 1000, "При сумме 1000 нужно докупить ещё 1000 для следующего порога");
    }

    @Test
    public void testRemainWhenAmountIsLessThanBoundary() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(900);
        Assert.assertEquals(result, 100, "Для 900 рублей нужно докупить 100");
    }

    @Test
    public void testRemainWhenAmountIsMoreThanBoundary() {
        CashbackHackService service = new CashbackHackService();
        int result = service.remain(1200);
        // 1200 % 1000 = 200, до следующей тысячи не хватает 800
        Assert.assertEquals(result, 800, "Для 1200 рублей нужно докупить 800");
    }
}