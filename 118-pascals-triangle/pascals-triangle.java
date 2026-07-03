class Solution {
    public List<List<Integer>> generate(int numRows) {
        List <List<Integer>> ans = new ArrayList<>();

        for(int row = 1;row<=numRows;row++){
            List <Integer> list = new ArrayList<>();
            long val = 1;
            list.add(1);

            for(int col=1;col<row;col++){
                val *= row-col;
                val/=col;
                list.add((int) val);
            } 
            ans.add(list);           
        }

        return ans;
    }
}