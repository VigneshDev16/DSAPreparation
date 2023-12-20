package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3,5,1,5,3,2};
        qsort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
    }
    static void qsort(int[] arr,int lo,int hi){
        if(lo >= hi){
            return;
        }

        int s = lo;
        int e = hi;
        int mid = s + (e-s)/2;

        while(s <= e){
            while(arr[s]<arr[mid]){
                s++;
            }
            while(arr[e]>arr[mid]){
                e--;
            }
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        qsort(arr,lo,e);
        qsort(arr,s,hi);
    }
}
