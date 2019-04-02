package org.preparation.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LexicoGraphicalOrder {

    public static void main(String[] args) {
        String[] sarr = {
                "key1 abcd",
                "key2 zzz",
                "key1 hello",
                "key3 world",
                "key1 hello"
        };
        Arrays.stream(solve(sarr)).forEach(System.out::println);
    }


    /*
     * Complete the solve function below.
     */

    static String[] solve(String[] arr) {

        Map<String, Holder> map = new HashMap<>();

        for (String str : arr) {
            //split the input
            String[] kv = str.split(" ");
            String key = kv[0];
            String val = kv[1];

            if (map.containsKey(key)) {
                Holder holder = map.get(key);
                if (val.compareTo(holder.highestValue) > 0) {
                    holder.highestValue = val;
                }
                holder.count++;
            } else {
                Holder holder = new Holder(1, val);
                map.put(key, holder);
            }

        }
        String[] result = new String[map.size()];

//       List<String> lists= new ArrayList<>();
//       map.forEach((key,value) ->  {
//          String str=  key + ":" + value.count + "," + value.highestValue;
//
//       });

        Set<String> keys = map.keySet();

        int curr = 0;
        for (String k : keys) {
            Holder holder = map.get(k);
            result[curr++] = k + ":" + holder.count + "," + holder.highestValue;
        }
        return result;

    }

    static class Holder {

        int    count;
        String highestValue;

        public Holder(int counter, String hv) {
            this.count = counter;
            this.highestValue = hv;
        }

    }
}
