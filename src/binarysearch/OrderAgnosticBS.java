package binarysearch;

public class OrderAgnosticBS {
        public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,6,7,8,9,12,34,45,68,97};
            int target = 12;
            int ans = orderAgnosticBS(arr,target);
            System.out.println(ans);
        }

        // return index
        // return -1 if answer is not found

        static int orderAgnosticBS(int[] arr,int target){
            int start = 0;
            int end = arr.length - 1;

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
