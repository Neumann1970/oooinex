package task1;

import java.util.Arrays;

public class VersionTask {

    public static void main(String[] args) {
        String[] strings = {"2.32.41","5.6.9","1.2.3","3.4.8","2.32.42","100.2.22", "2000.2.22", "2.2000.2"};
        getSortedVersionsArray(strings);
        System.out.println(Arrays.toString(getSortedVersionsArray(strings)));
    }

    private static String[] getSortedVersionsArray(String[] strings){
        Arrays.sort(strings,VersionTask::compare);
        return strings;
    }

    private static int compare(String o1, String o2) {
        String[] split1 = o1.split("\\."), split2 = o2.split("\\.");
        int result = 0;
        for (int i = 0; i < Math.min(split1.length, split2.length); i++) {
            if ((result = Integer.compare(Integer.parseInt(split1[i]), Integer.parseInt(split2[i]))) != 0) {
                return result;
            }
        }
        return Integer.compare(split1.length, split2.length);
    }
}
