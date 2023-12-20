package binarysearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,12,34,45,68,97};
        int target = 12;
        int res = ans(arr,target);
        System.out.println(res);
    }

    static int ans(int[] arr,int target){
        int start = 0;
        int end = 1;
        int bs = 2;
        while(target > arr[end]){
            start = end + 1;
            bs = bs * 2;
            end = end + bs;
        }
        return BSearch(arr,target,start,end);
    }

    static int BSearch(int[] arr,int target,int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < arr[mid]){
                end = mid -1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
