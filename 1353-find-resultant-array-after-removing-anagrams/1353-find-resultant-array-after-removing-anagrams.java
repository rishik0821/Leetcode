class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        if(n==1){
            result.add(words[0]);
            return result;
        }

         result.add(words[0]);
        for(int i=1;i<n;i++){
             if (!isAn(words[i], words[i - 1])) {
                result.add(words[i]);
            }
            
        }

        return result;
    }

    public boolean isAn(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if(n!=m){
            return false;
        }
        int[] x = new int[26];
 

        for(int i=0;i<n;i++){
            x[s1.charAt(i)-'a']++;
            x[s2.charAt(i)-'a']--;

        }

        for(int i=0;i<26;i++){
            if(x[i]!=0){
                return false;
            }
        }

        return true;

    }
}