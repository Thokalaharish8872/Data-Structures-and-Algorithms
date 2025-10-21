class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;

        while(left < right){
            int sum = numbers[left]+numbers[right];
            if(sum == target) break;
            else if(sum > target) right--;
            else left++;
        }
        int[] ans = new int[2];
        ans[0] = left+1;
        ans[1] = right+1;
        return ans;
    }
}