public class LeetCode_13 {
    public int romanToInt(String s) {
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
         */
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'M' -> {
                    res += 1000;
                }
                case 'D' -> res += 500;
                case 'C' -> {
                    if(i < s.length() - 1 && s.charAt(i +1) == 'D') {
                        res += 400;
                        i++;
                    } else  if(i < s.length() - 1 && s.charAt(i +1) == 'M'){
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                }
                case 'L' -> res += 50;
                case 'X' -> {
                    if(i < s.length() - 1 && s.charAt(i +1) == 'C') {
                        res += 90;
                        i++;
                    } else  if(i < s.length() - 1 && s.charAt(i +1) == 'L'){
                        res += 40;
                        i++;

                    } else {
                        res += 10;
                    }
                }
                case 'V' -> res += 5;
                case 'I' -> {
                    if(i < s.length() - 1 && s.charAt(i +1) == 'X') {
                        res += 9;
                        i++;
                    } else  if(i < s.length() - 1 && s.charAt(i +1) == 'V'){
                        res += 4;
                        i++;

                    } else {
                        res++;
                    }
                }
            }

        }
        return res;
    }
}
