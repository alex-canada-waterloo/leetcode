package com.naianzin.leetcode.top_interview_150.array_string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        var result = new ArrayList<String>();
        var p = 0;


        var letters = 0;
        var gaps = 0;
        var wordsInLine = 0;
        while (p <= words.length) {

            // flush?
            var flush = false;
            if (p == words.length) {
                flush = true;
            } else {
                var potentialLength = letters + gaps + words[p].length();
                if (potentialLength >= maxWidth && wordsInLine > 0) {
                    flush = true;
                }
            }
            if (flush) {
                var leftP = p - wordsInLine;
                var rightP = p - 1;
                var spacesToFill = maxWidth - letters;
                var sb = new StringBuilder(maxWidth);
                for (var i = leftP; i <= rightP; i++) {

                    if (wordsInLine == 1) {
                        sb.append(words[i]);
                        sb.append(" ".repeat(spacesToFill));
                    } else if (sb.isEmpty()) {
                        sb.append(words[i]);
                    } else if (p == words.length) {
                        // last line left justified
                        sb.append(' ');
                        sb.append(words[i]);
                        spacesToFill--;
                        if (i == rightP) {
                            sb.append(" ".repeat(spacesToFill));
                        }
                    } else {
                        var space = spacesToFill / gaps;
                        var reminder = spacesToFill % gaps;
                        if (reminder > 0) {
                            space++;
                        }
                        spacesToFill -= space;
                        gaps--;
                        sb.append(" ".repeat(space));
                        sb.append(words[i]);
                    }
                }
                letters = 0;
                gaps = 0;
                wordsInLine = 0;
                result.add(sb.toString());
            }
            if (p < words.length) {
                letters += words[p].length();
                if (wordsInLine >= 1) {
                    gaps++;
                }
                wordsInLine++;
            }
            p++;
        }
        return result;
    }

    public static void main(String[] args) {
        var service = new TextJustification();

        var r1 = service.fullJustify(new String[] {
                "Listen","to","many,","speak","to","a","few."
        }, 6);
        System.out.println("'" + r1.get(0) + "' 'What   must   be'");
        System.out.println("'" + r1.get(1) + "' 'acknowledgment  '");
        System.out.println("'" + r1.get(2) + "' 'shall be        '");
    }
}
