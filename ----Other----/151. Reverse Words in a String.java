/*
 * medium
 */

class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        ch = removeSpaces(ch);
        reverseString(ch, 0, ch.length - 1);
        reverseEachWord(ch);
        return new String(ch);
    }

    public char[] removeSpaces(char[] ch) {
        int slow = 0;
        for (int fast = 0; fast < ch.length; fast++) {
            if (ch[fast] != ' ') {
                if (slow != 0) {
                    ch[slow] = ' ';
                    slow++;
                }

                while (fast < ch.length && ch[fast] != ' ') {
                    ch[slow] = ch[fast];
                    fast++;
                    slow++;
                }
            }
        }
        char[] newChar = new char[slow];
        System.arraycopy(ch, 0, newChar, 0, slow);
        return newChar;
    }

    public void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    public void reverseEachWord(char[] ch) {
        int start = 0;
        for (int end = 0; end <= ch.length; end++) {
            if (end == ch.length || ch[end] == ' ') {
                reverseString(ch, start, end - 1);
                start = end + 1;
            }
        }
    }
}
