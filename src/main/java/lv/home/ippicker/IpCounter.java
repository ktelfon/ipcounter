package lv.home.ippicker;

import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpCounter {

    public static final String ZERO_TO_255_REGEX
            = "(\\d{1,2}|(0|1)\\"
            + "d{2}|2[0-4]\\d|25[0-5])";

    public static final String IP_REGEX
            = ZERO_TO_255_REGEX + "\\."
            + ZERO_TO_255_REGEX + "\\."
            + ZERO_TO_255_REGEX + "\\."
            + ZERO_TO_255_REGEX;

    private long uniqIpCounter;

    private BitSet smallIpBitset;
    private BitSet bigIpBitSet;

    private Pattern ipPattern = Pattern.compile(IP_REGEX);

    public IpCounter() {
        this.smallIpBitset = new BitSet();
        this.bigIpBitSet = new BitSet();
        uniqIpCounter = 0;
    }

    public void countIp(String ip) {

        if (isIpInValid(ip)) return;
        BitSet pickedBitset = smallIpBitset;
        long ipIndex = toLongValue(ip);
        if (ipIndex > Integer.MAX_VALUE) {
            pickedBitset = bigIpBitSet;
            ipIndex = (ipIndex - Integer.MAX_VALUE);
        }
        if (!pickedBitset.get((int) ipIndex - 1)) {
            uniqIpCounter++;
            pickedBitset.set((int) ipIndex - 1);
        }
    }

    static long toLongValue(String ipString) {
        StringBuilder field = new StringBuilder(3);
        int startIndex = 0;
        long result = 0;

        for (int i = 0; i < 3; i++) {
            int spacerPosition = ipString.indexOf('.', startIndex);
            field.append(ipString, startIndex, spacerPosition);
            int fieldValue = Integer.parseInt(field.toString());
            field.setLength(0);
            result += fieldValue * Math.pow(256, 3 - i);
            startIndex = spacerPosition + 1;
        }
        result += Integer.parseInt(ipString.substring(startIndex));

        return result;
    }

    public boolean isIpInValid(String ip) {
        if (ip == null) {
            return true;
        }

        Matcher ipPatternMatcher = ipPattern.matcher(ip);

        if (!ipPatternMatcher.matches()) {
            return true;
        }
        return false;
    }

    public long getUniqIpCounter() {
        return uniqIpCounter;
    }

}
