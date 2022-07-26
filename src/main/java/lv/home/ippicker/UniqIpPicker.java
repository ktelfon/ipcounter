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

    public long pickUniqIpsFromFile(String fileName) {

        if (fileName == null || fileName.length() == 0) {
            System.out.println(" no file name provided");
            return 0;
        }
        Class clazz = UniqIpPicker.class;
        InputStream inputStream = clazz.getResourceAsStream("/" + fileName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                ipCounter.countIp(line);
            }
        } catch (IOException e) {
            System.out.println("Ups something went wrong with the file");
        } finally {
            long uniqIpCounter = ipCounter.getUniqIpCounter();
            System.out.println("Found: "
                    + uniqIpCounter
                    + " uniq Ip's");
            return uniqIpCounter;
        }
    }

    public IpCounter getIpCounter() {
        return ipCounter;
    }

    public void setIpCounter(IpCounter ipCounter) {
        this.ipCounter = ipCounter;
    }
}
