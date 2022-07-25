package lv.home.ippicker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IpCounterTest {

    IpCounter ipCounter;

    @BeforeEach
    void testSetup() {
        ipCounter = new IpCounter();
    }

    @Test
    void toLongValue() {
        String validIp = "1.1.1.1";
        String inValidIp = "1.1.1.2";
        ipCounter.countIp(validIp);
        int expectedAmountOfIps = 1;
        assertEquals(expectedAmountOfIps, ipCounter.getUniqIpCounter());
    }

    @Test
    void isIpInValid() {
        String invalidIp = "129837";
        boolean ipInValid = ipCounter.isIpInValid(invalidIp);
        assertTrue(ipInValid);
    }

}