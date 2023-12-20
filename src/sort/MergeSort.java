package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr= {8,3,4,12,5,6};
        int[] sorted = mergeSort(arr);
        mergeSortInPlace(arr,0, arr.length);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(arr));

    }
    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int mixIndex = 0;

        while(leftIndex < left.length && rightIndex < right.length ){
            if(left[leftIndex] < right[rightIndex]){
                mix[mixIndex] = left[leftIndex];
                mixIndex++;
                leftIndex++;
            }else{
                mix[mixIndex] = right[rightIndex];
                mixIndex++;
                rightIndex++;
            }
        }

        while(leftIndex < left.length ){
            mix[mixIndex] = left[leftIndex];
            mixIndex++;
            leftIndex++;
        }

        while (rightIndex < right.length ){
            mix[mixIndex] = right[rightIndex];
            mixIndex++;
            rightIndex++;
        }
        return mix;
    }

    static void mergeSortInPlace(int[] arr,int start,int end){
        if(end-start==1){
            return;
        }
        int mid = (start+end)/2;
        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid,end);

        mergeInPlace(arr,start,mid,end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end-start];

        int leftIndex = start;
        int rightIndex = mid;
        int mixIndex = 0;

        while(leftIndex < mid && rightIndex < end ){
            if(arr[leftIndex] < arr[rightIndex]){
                mix[mixIndex] = arr[leftIndex];
                mixIndex++;
                leftIndex++;
            }else{
                mix[mixIndex] = arr[rightIndex];
                mixIndex++;
                rightIndex++;
            }
        }

        while(leftIndex < mid ){
            mix[mixIndex] = arr[leftIndex];
            mixIndex++;
            leftIndex++;
        }

        while (rightIndex < end ){
            mix[mixIndex] = arr[rightIndex];
            mixIndex++;
            rightIndex++;
        }

        for (int i = 0; i < mix.length; i++) {
            arr[start+i]=mix[i];

        }
    }
}
