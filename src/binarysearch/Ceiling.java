package binarysearch;

public class Ceiling {
        public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,6,7,8,9,12,34,45,68,97};
            int target = 11;
            int ans = ceiling(arr,target);
            System.out.println(ans);
        }

        // return index
        // return -1 if answer is not found

        static int ceiling(int[] arr,int target){
            int start = 0;
            int end = arr.length - 1;
            if(target > arr[end]){
                return -1;
            }

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
            return start;
        }
}
