package lv.home.ippicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UniqIpPicker {
    private IpCounter ipCounter;

    public UniqIpPicker() {
        this.ipCounter = new IpCounter();
    }

    public long pickUniqIpsFromFile(String fileName) throws IOException {
        Class clazz = UniqIpPicker.class;
        InputStream inputStream = clazz.getResourceAsStream("/" + fileName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                ipCounter.countIp(line);
            }
        } finally {
            long uniqIpCounter = ipCounter.getUniqIpCounter();
            System.out.println("Found: "
                    + uniqIpCounter
                    + " uniq Ip's");
            return uniqIpCounter;
        }
    }
}
