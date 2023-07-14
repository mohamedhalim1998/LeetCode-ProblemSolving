import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        int width = 0;
        int start = 0;
        while (index < words.length) {
            if (words[index].length() + width > maxWidth) {
                width--;
                lines.add(constructLine(words, start, index, maxWidth - width));
                start = index;
                width = 0;
                continue;
            }
            if (words[index].length() + width == maxWidth) {
                index++;
                lines.add(constructLine(words, start, index, 0));
                start = index;
                width = 0;
                continue;
            }

            width += words[index].length() + 1;
            index++;
        }
        if(start < words.length) {
            StringBuilder line = new StringBuilder();
            for (int i = start; i < words.length; i++) {
                line.append(words[i]).append(" ");
            }
            line.append(" ".repeat(maxWidth - width));
            lines.add(line.toString());
        }
        return lines;
    }

    private String constructLine(String[] words, int start, int end, int spaces) {
        StringBuilder line = new StringBuilder();
        int count = end - start;
        if(count == 1) {
            return line.append(words[start]).append(" ".repeat(spaces)).toString();
        }
        int between = spaces / (count-1);
        int left = spaces % (count-1);
        for (int i = start; i < end- 1; i++) {
            line.append(words[i]).append(" ".repeat(between+1));
            if(left > 0) {
                left--;
                line.append(' ');
            }
        }
        line.append(words[end-1]);
        return line.toString();


    }

    @Test
    public void test() {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int max = 16;
        fullJustify(words, max).forEach(System.out::println);
    }
}
