class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;

        for (int num : arr) {
            if (num == 0) {
                zeros++;
            }
        }

        int i = arr.length - 1;
        int j = arr.length + zeros - 1;

        while (i < j) {
            if (j < arr.length) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;

                if (j < arr.length) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
    }
}