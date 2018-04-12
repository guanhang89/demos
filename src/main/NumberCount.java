package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberCount {

    private List<Integer> list;

    public List<Integer> ListcountNumberStr(String str, int num) {
        list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for(int i =0;i<chars.length;) {
            if (chars[i] > '0' && chars[i] < '9') {
                StringBuilder builder = new StringBuilder();
                builder.append(chars[i]);
                i = i + 1;
                while (i < chars.length && chars[i] > '0' && chars[i] < '9') {
                    builder.append(chars[i]);
                    i = i + 1;
                }
                if (builder.toString().length() > 0) {
                    int result = Integer.parseInt(builder.toString());
                    if (result > num) {
                        list.add(result);
                    }
                }

            } else {
                i = i + 1;
            }
        }
        return list;

    }

    public static void main(String[] args) {
        NumberCount numberCount = new NumberCount();
        List<Integer> list = numberCount.ListcountNumberStr("cag333dog2323nice2323", 1000);
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
