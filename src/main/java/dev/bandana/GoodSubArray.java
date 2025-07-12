package dev.bandana;


import java.util.Scanner;

/*
   Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.

 */
public class GoodSubArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        Scanner sc = new Scanner(System.in);
        int B = sc.nextInt();

        findGoodSubArr(arr,B);
    }
    public static void findGoodSubArr(int [] arr, int B) {
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                int len = j-i+1;
                sum += arr[j];
                if((len%2==0 && sum<B) || (len%2!=0 && sum>B)){
                    count++;
                }
            }
        }

        System.out.println("Count of GoodSubArr: "+ count);

    }

}
