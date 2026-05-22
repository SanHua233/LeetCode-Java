package com.mid.Q33;

public class Solution {
    public int search(int[] nums, int target) {
        // 思路：
        // 1. 先将旋转后的数组恢复 （二分 --> 找非升序位置）
        // 2. 升序数组查找数字
        int begin = 0;
        int end = nums.length-1;
        int mid = (begin + end) / 2;

        int rotate_num = 0;
        if (nums[mid] < nums[begin]){
            rotate_num = getUnAscendNum(nums, begin, mid);
        }
        if (nums[end] < nums[mid]){
            rotate_num = getUnAscendNum(nums, mid , end);
        }
        // System.out.println(rotate_num);

        int beg_idx = 0;
        int end_idx = nums.length-1;
        int mid_idx;
        while (beg_idx <= end_idx){
            mid_idx = ( beg_idx + end_idx ) / 2;
            // System.out.println(">:"+beg_idx+"|"+mid_idx+"|"+end_idx);
            // 找到 target, 返回索引
            if (nums[ (mid_idx+rotate_num) % nums.length] == target){
//                System.out.println(mid_idx);
//                break;
                return (mid_idx+rotate_num) % nums.length;
            }
            else if(nums[ (mid_idx+rotate_num) % nums.length] < target){
                // 右半区
                beg_idx = mid_idx + 1;
            }
            else{
                // 左半区
                end_idx = mid_idx - 1;
            }
        }
        return -1;
    }

    // 如果 end 小于 begin, 则递归调用,
    public int getUnAscendNum(int[] nums, int begin, int end){
        int mid = (begin + end) / 2;
        // System.out.println(">:"+begin+"|"+mid+"|"+end);
        if (begin == mid){
            return end;
        }
        else{
            if (nums[mid] < nums[begin]){
                return getUnAscendNum(nums, begin, mid);
            }
            else {
                return getUnAscendNum(nums, mid, end);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        // beg = 0, end = 6, mid = 3
        // nums[6] < nums[3]
        // beg = 3, end = 6, mid = 4
        // nums[4] < nums[3]
        // beg = 3, end = 4, mid = 3
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int result1 = solution.search(nums1, target1);
        System.out.println(result1); // 预期输出 4

        // 示例 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = solution.search(nums2, target2);
        System.out.println(result2); // 预期输出 -1

        // 示例 3
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = solution.search(nums3, target3);
        System.out.println(result3); // 预期输出 -1

        int[] nums4 = {1,3};
        int target4 = 3;
        int result4 = solution.search(nums4, target4);
        System.out.println(result4); // 预期输出 1
    }
}