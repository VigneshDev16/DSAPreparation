package binarysearch;

public class SearchRotatedArr {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        int pivot = findPivotwithDuplicates(nums);
        int ans = -1;

        System.out.println(pivot);

        if(target == nums[pivot]){
            ans = pivot;
        }else if(nums[0] <= target){
            ans = BSearch(nums,target,0,pivot-1);
        }else{
            ans = BSearch(nums,target,pivot+1,nums.length-1);
        }
        System.out.println(ans);
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return  mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return  mid-1;
            }
            if(arr[start] >=  arr[mid]){
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int findPivotwithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return  mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return  mid-1;
            }
           if(arr[mid]==arr[start] && arr[mid] == arr[end]){
               //skipping the dupes
               if(arr[start]>arr[start+1]){
                   return start;
               }
               start++;
               if(arr[end] < arr[end-1]){
                   return end-1;
               }
               end++;
           } else if (arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid] > arr[end]) {
               start = mid+1;
           } else {
               end = mid -1;
           }
        }
        return -1;
    }

    static int BSearch(int[] arr,int target,int start,int end){

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
