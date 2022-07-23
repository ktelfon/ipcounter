package lv.home.ippicker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UniqIpPickerTest {

    UniqIpPicker uniqIpPicker;
    IpCounter ipCounter = Mockito.mock(IpCounter.class);
    private final String fileName = "ip.txt";
    long amountOfIps = 2;

    @BeforeEach
    void setUp() {
        uniqIpPicker = new UniqIpPicker();
        uniqIpPicker.setIpCounter(ipCounter);
        when(ipCounter.getUniqIpCounter()).thenReturn(amountOfIps);

    }

    @Test
    void readsFile() {
        uniqIpPicker.pickUniqIpsFromFile(fileName);
        assertEquals(amountOfIps, uniqIpPicker.getIpCounter());
    }

    @Test
    void noFileTest() {
        int expected = 0;
        assertEquals(expected, uniqIpPicker.pickUniqIpsFromFile(null));
    }
}