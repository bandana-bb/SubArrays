package dev.bandana;

import java.util.Scanner;

/*  # Revise again
   You are given an integer array A of size N.
You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.
 */
public class PickFromBothSide {
    public static void main(String[] args) {

        int arr [] = {5,-2,3,1,2};
        Scanner sc = new Scanner(System.in);
        int B =sc.nextInt();
        pickBothside(arr, B);
    }

    public static void pickBothside(int arr [], int B){
        int n = arr.length;

        int suff []=new int [n+1];
        suff[n-1]=arr[n-1];
        suff[n]= 0;

        for(int i = n-2; i>=0; i--){
            suff[i] = suff[i+1] + arr[i];
        }

        int pref_sum = 0;
        int ans = suff[n-B];
        for(int i=0; i< B; i++){
            pref_sum = pref_sum + arr[i];
            int suff_sum = suff[n-B+(i+1)];
            ans = Math.max(ans, suff_sum+pref_sum);
        }

        System.out.println(ans);

    }
}

