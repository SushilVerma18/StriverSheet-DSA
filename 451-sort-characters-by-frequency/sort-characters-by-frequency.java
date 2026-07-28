class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];

        for(char ch : s.toCharArray()){
            freq[ch]++;
        }

        Character[] chars = new Character[128];
        int count =0;

        for(int i=0;i<128;i++){
            if(freq[i] > 0){
                chars[count++] = (char) i; 
            }
        }

        Arrays.sort(chars,0,count,(a,b) -> freq[b] - freq[a]);

        StringBuilder ans = new StringBuilder();

        for(int j=0;j<count;j++){
            char ch = chars[j];

            for(int k=0;k<freq[ch];k++){
                ans.append(ch);
            }
        }

        return ans.toString();
     } 
}