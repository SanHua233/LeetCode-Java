package com.easy.Q3633;

public class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // 思路：分两种情况，先水或者先地，先水的情况下，找出完成最早的，然后再在这个最早成的水后面找最快完成的地，反之同理
        int[] landEndTime = new int[landStartTime.length];
        int[] waterEndTime = new int[waterStartTime.length];
        // 计算最早完成时间
        int waterLess = 9999, landLess = 9999;
        for (int i = 0; i < landStartTime.length; i++) {
            landEndTime[i] = landStartTime[i] + landDuration[i];
            if (landEndTime[i] < landLess){
                landLess = landEndTime[i];
            }
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            waterEndTime[i] = waterStartTime[i] + waterDuration[i];
            if (waterEndTime[i] < waterLess){
                waterLess = waterEndTime[i];
            }
        }
        int wl = 9999,lw = 9999;
        // 先水
        for (int i = 0; i < landStartTime.length; i++) {
            if (landStartTime[i] <= waterLess){
                // 开始时间早于水的结束时间
                wl = Math.min(wl, waterLess + landDuration[i]);
            }
            else{
                // 开始时间晚于水的结束时间（还得等）
                wl = Math.min(wl, landEndTime[i]);
            }
        }

        // 先陆地
        for (int i = 0; i < waterStartTime.length; i++) {
            if (waterStartTime[i] <= landLess){
                // 开始时间早于陆地的结束时间
                lw = Math.min(lw, landLess + waterDuration[i]);
            }
            else{
                // 开始时间晚于陆地的结束时间（还得等）
                lw = Math.min(lw, waterEndTime[i]);
            }
        }

        return Math.min(lw,wl);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] landStartTime1 = {2, 8};
        int[] landDuration1 = {4, 1};
        int[] waterStartTime1 = {6};
        int[] waterDuration1 = {3};
        int result1 = solution.earliestFinishTime(landStartTime1, landDuration1, waterStartTime1, waterDuration1);
        System.out.println(result1); // 预期输出 9

        // 示例 2
        int[] landStartTime2 = {5};
        int[] landDuration2 = {3};
        int[] waterStartTime2 = {1};
        int[] waterDuration2 = {10};
        int result2 = solution.earliestFinishTime(landStartTime2, landDuration2, waterStartTime2, waterDuration2);
        System.out.println(result2); // 预期输出 14
    }
}