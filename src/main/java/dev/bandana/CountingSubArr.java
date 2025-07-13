package dev.bandana;

/*
  Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.
 */

import java.util.Scanner;

public class CountingSubArr {
    public static void main(String[] args) {
        int [] arr = {1, 11, 2, 3, 15};
        Scanner in = new Scanner(System.in);
        int B = in.nextInt();

        findSumSubArr(arr,B);
    }

    //Brute force Approach
    public static void findSumSubArr(int[] arr, int B) {
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for (int j=i;j<n;j++){
                sum += arr[j];
                if(sum<B){
                    count++;
                }
            }

        }
        System.out.println("Count of SumSubArr having sum less than B :" +count);
    }

}
