//easy
//time: O(m+n);spaceO(m+n)

//string
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";

        for (int i = 0; i < word1.length; i++) {
            s1 += word1[i];
        }
        for (int j = 0; j < word2.length; j++) {
            s2 += word2[j];
        }

        return s1.equals(s2);

    }
}

// string.join
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);
        return s1.equals(s2);
    }
}
