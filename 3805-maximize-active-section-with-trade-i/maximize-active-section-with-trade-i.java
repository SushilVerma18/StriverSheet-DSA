class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int activeCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                activeCount++;
            }
        }

        List<Integer> inactiveBlock = new ArrayList<>();
        int i=0;
        
        while(i<n){
            if(s.charAt(i)=='0'){
                int start=i;
                while(i<n && s.charAt(i)=='0') i++;

                inactiveBlock.add(i - start);
            }
            else{
                i++;
            }
        }

        int maxPairSum = 0;

        for(int j=1;j<inactiveBlock.size();j++){
            maxPairSum = Math.max(maxPairSum,inactiveBlock.get(j) + inactiveBlock.get(j-1));
        }

        return maxPairSum + activeCount;
    }
}