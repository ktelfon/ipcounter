package lv.home.ippicker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.nio.file.NoSuchFileException;

import static lv.home.ippicker.UniqIpPicker.NO_FILE_NAME_PROVIDED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UniqIpPickerTest {

    UniqIpPicker uniqIpPicker;
    IpCounter ipCounter = Mockito.mock(IpCounter.class);
    private final String fileName = "ip.txt";
    long amountOfIps = 2;

    @BeforeEach
    void setUp() {
        uniqIpPicker = new UniqIpPicker(ipCounter);
        when(ipCounter.getUniqIpCounter()).thenReturn(amountOfIps);

    }

    @Test
    void readsFile() throws NoSuchFileException {
        long result = uniqIpPicker.pickUniqIpsFromFile(fileName);
        assertEquals(amountOfIps, result);
    }

    @Test
    void noFileTest()  {
        Exception exception = assertThrows(NoSuchFileException.class, () -> {
            uniqIpPicker.pickUniqIpsFromFile(null);
        });

        String expectedMessage = NO_FILE_NAME_PROVIDED;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}