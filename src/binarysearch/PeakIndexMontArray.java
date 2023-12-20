package binarysearch;

public class PeakIndexMontArray {
    public static void main(String[] args) {
        int[] arr ={0,3,6,8,9,6,4,3,1};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] < arr[mid+1]){
                start = mid + 1;
            }else if(arr[mid] > arr[mid+1]){
                end = mid;
            }
        }
        return start;
    }
}
