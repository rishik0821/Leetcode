class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        Map<Integer,List<Integer>> diagonals = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                int diff = i-j;
                diagonals.computeIfAbsent(diff,k->new ArrayList<>()).add(grid[i][j]);
            }

        }
        for(Map.Entry<Integer,List<Integer>> entry : diagonals.entrySet()){
            int diff = entry.getKey();
            List<Integer> diagonalList = entry.getValue();
            if(diff>=0){
                Collections.sort(diagonalList,Collections.reverseOrder());
            }else{
                Collections.sort(diagonalList);
            }
        }
        Map<Integer,Integer> diagonalIndices = new HashMap<>();
        for(Integer diff : diagonals.keySet()){
            diagonalIndices.put(diff,0);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int diff = i-j;
                List<Integer> diagonalList = diagonals.get(diff);
                int currentIdx = diagonalIndices.get(diff);
                grid[i][j]= diagonalList.get(currentIdx);
                diagonalIndices.put(diff,currentIdx+1);
            }
        }
        return grid;
    }
}