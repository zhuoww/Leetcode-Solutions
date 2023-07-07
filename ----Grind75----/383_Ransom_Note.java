class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] library = new int[26];

        if (ransomNote.length() > magazine.length())// remember!
            return false;

        for (int i = 0; i < magazine.length(); i++) {
            library[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            library[ransomNote.charAt(i) - 'a']--;
        }

        for (int c : library) {
            if (c < 0) {
                return false;
            }
        }
        return true;
    }
}
