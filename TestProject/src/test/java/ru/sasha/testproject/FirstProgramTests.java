package ru.sasha.testproject;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by AZaharov on 12.05.2017.
 */
public class FirstProgramTests {

    @Test
    public void testSendWord () {
        SendWord s = new SendWord("Word");
        Assert.assertEquals(s.writeWord(), ("Word"));
    }
}
