package com.mk.sample.tests;

public class LongestNonNegativeSumSlice {

    public static void main(String[] args) {
        LongestNonNegativeSumSlice longestNonNegativeSumSlice = new LongestNonNegativeSumSlice();
        longestNonNegativeSumSlice.runTests();
    }

    private int solution(int a[], int n) {
        int biggestCount = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;
            for (int j = i; j < n; j++) {
                sum = sum + a[j];
                if (sum < 0) {
                    break;
                } else {
                    count++;
                }
            }
            if (biggestCount < count) {
                biggestCount = count;
            }
        }
        return biggestCount;
    }

    private void runTests() {
        int a1[] = {-1, -1, 1, -1, 1, 0, 1, -1, -1};
        System.out.println("Test 1 >> " + solution(a1, a1.length));

        int a2[] = {1,1,-1,-1,-1,-1,-1,1,1};
        System.out.println("Test 2 >> " + solution(a2, a2.length));
    }

}
