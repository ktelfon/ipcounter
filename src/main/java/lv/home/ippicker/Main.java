package lv.home.ippicker;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        UniqIpPicker uniqIpPicker = new UniqIpPicker(new IpCounter());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your file name and path:");
        String input = scanner.next();
        long l = uniqIpPicker.pickUniqIpsFromFile(input);
        System.out.println(l);
    }

}
