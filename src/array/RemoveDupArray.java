package array;

public class RemoveDupArray {
    public static void main(String[] args) {
        int k = removeDuplicates(new int[]{1, 1, 2});
        System.out.println(k);
    }
    static int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[index] != nums[i]){
                nums[index+1] = nums[i];
                index++;
            }
        }
        return index+1;
    }
}
