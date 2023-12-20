package array;

public class RemoveElementArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int val = 3;
        int res = removeElement(nums,val);
        System.out.println(res);
    }
    static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
