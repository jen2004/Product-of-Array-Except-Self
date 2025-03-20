public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Compute left products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Compute right products and final result in one pass
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.print("Output for nums1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.print("Output for nums2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}