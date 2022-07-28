package lv.home.ippicker;

import java.io.*;
import java.nio.file.NoSuchFileException;

public class UniqIpPicker {
    public static final String NO_FILE_NAME_PROVIDED = "No file name provided";
    private IpCounter ipCounter;

    public UniqIpPicker(IpCounter ipCounter) {
        this.ipCounter = ipCounter;
    }

    public long pickUniqIpsFromFile(String fileName) throws NoSuchFileException {

        validateFileName(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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

    private static void validateFileName(String fileName) throws NoSuchFileException {
        if (fileName == null || fileName.length() == 0) {
            throw new NoSuchFileException(NO_FILE_NAME_PROVIDED);
        }
    }
}
