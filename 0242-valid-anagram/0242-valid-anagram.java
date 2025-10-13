class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }
        int[] x = new int[26];
        int[] y = new int[26];

        for(int i=0;i<n;i++){
            x[s.charAt(i)-'a']++;
            x[t.charAt(i)-'a']--;

        }

        for(int i=0;i<26;i++){
            if(x[i]!=0){
                return false;
            }
        }

        return true;
    }
}