public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int out = 0;
       for (int i = 0; i < 32; i++) {
            out <<= 1;
            out = out | (n & 1);
            n >>= 1;
        }
        return out;
    }
}
