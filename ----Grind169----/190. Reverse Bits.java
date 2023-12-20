/*
 * easy
 * time:O(1);space:O(1)
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        // 循环 32 次，因为是针对 32 位整数进行反转
        for (int i = 0; i < 32; i++) {
            // 从输入整数 n 的二进制表示中取出第 i 位的值（0 或 1）
            int bit = (n >> i) & 1;
            // 通过 bit << (31 - i) 将 bit 移动到正确reverse的位置
            res = res ^ (bit << (31 - i));
        }
        return res;
    }
}