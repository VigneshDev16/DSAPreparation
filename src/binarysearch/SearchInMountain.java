package binarysearch;

public class SearchInMountain {
    public static void main(String[] args) {
        int[] arr ={0,3,6,8,9,6,4,3,1};
        int ans = findInMountainArray(6,arr);
        System.out.println(ans);
    }

    static int findInMountainArray(int target, int[] arr) {
        int peak = peakIndexInMountainArray(arr);
        if(target == arr[peak]){
            return  peak;
        }
        int ans = -1;
        ans = BSearch(arr,target,0,peak);
        if(ans != -1){
            return ans;
        }
        return BSearch(arr,target,peak,arr.length-1);
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

    static int BSearch(int[] arr,int target,int start, int end){
            boolean isAsc = arr[start] < arr[end];

            while(start <= end){
                int mid = start + (end - start)/2;

                if(isAsc) {
                    if (target < arr[mid]) {
                        end = mid - 1;
                    } else if (target > arr[mid]) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }else{
                    if (target > arr[mid]) {
                        end = mid - 1;
                    } else if (target < arr[mid]) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
        }
}
