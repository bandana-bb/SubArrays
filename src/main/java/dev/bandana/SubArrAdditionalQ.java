package dev.bandana;

import java.util.HashSet;

/*
    **********Count Subarrays****************
    Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.
Since the number of subarrays could be large, return value % 109 +7.
 */
public class SubArrAdditionalQ {
    public static void main(String[] args) {

        int arr [] = {1,1,3};
        uniqueElements(arr);

    }

    public static void uniqueElements(int[] arr) {
        int mod = 1000000007;
        int count = 0;

        for (int i=0; i<arr.length; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j = i; j<arr.length; j++) {
                if(set.contains(arr[j])) {
                    break;
                }
                else {
                    set.add(arr[j]);
                    count = (count+1)%mod;
                }
            }
        }
        System.out.println("Count of unique subArr: " +count);
    }

}
