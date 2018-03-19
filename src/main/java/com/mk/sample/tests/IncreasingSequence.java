package com.mk.sample.tests;

import java.util.Arrays;

public class IncreasingSequence {


    public static void main(String[] args) {
        IncreasingSequence increasingSequence = new IncreasingSequence();
        increasingSequence.runTests();
    }

    private int solution(int a[], int b[], int n) {
        int minCount = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i-1]|| b[i] <= b[i-1]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
                if (a[i] <= a[i-1]|| b[i] <= b[i-1]) {
                    return -1;
                } else {
                    minCount++;
                }
            }
        }
        System.out.println("A >> " + Arrays.toString(a));
        System.out.println("B >> " + Arrays.toString(b));
        return minCount;
    }

    private void runTests() {

        int a1[] = {5,3,7,7,10};
        int b1[] = {1,6,6,9,9};
        System.out.println("Test 1 >> " + solution(a1, b1, 5));

        int a2[] = {5,-3,6,4,8};
        int b2[] = {2,6,-5,1,0};
        System.out.println("Test 2 >> " + solution(a2, b2, 5));

        int a3[] = {1,5,6};
        int b3[] = {-2,0,2};
        System.out.println("Test 3 >> " + solution(a3, b3, 3));

    }

}
