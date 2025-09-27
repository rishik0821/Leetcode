class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result =new ArrayList<>();
        helper(result,0,0,"",n);
        return result;
    }

    public void helper(List<String> result, int open,int closed, String str, int n){
        if(str.length()==2*n){
            result.add(str);
            return;
        }

        if(open<n){
            helper(result,open+1,closed,str+"(",n);
        }
        if(closed<open){
            helper(result,open,closed+1,str+")",n);
        }
    }
}