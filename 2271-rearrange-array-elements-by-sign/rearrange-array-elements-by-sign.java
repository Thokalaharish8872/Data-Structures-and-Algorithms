class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2],neg = new int[n/2];

        for(int i=0,j=0,k=0;i<n;i++){
            if(nums[i] < 0) neg[j++] = nums[i];
            else pos[k++] = nums[i];
        }

        for(int i=0;i<n;i+=2){
            nums[i] = pos[i/2];
            nums[i+1] = neg[i/2];
        }

        return nums;
    }
}