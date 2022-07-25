package lv.home.ippicker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        UniqIpPicker uniqIpPicker = new UniqIpPicker();
        long l = uniqIpPicker.pickUniqIpsFromFile("ip.txt");
        System.out.println(l);
    }

}
