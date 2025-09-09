class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
       int l=0;
       int r=0;
        int max=0;
        int maxf = 0;
        int hash[] = new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxf = Math.max(maxf,hash[s.charAt(r)-'A']);
            int changes = (r-l+1)-maxf;
            if(changes>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if(changes<=k){
                max = Math.max(max,r-l+1);
            }
            r++;
        }
        return max;
    }
}