package linkedList;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LeetCodePrblms {
    //https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
        }

        return s;
    }
    //https://leetcode.com/problems/linked-list-cycle/
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }

        return false;
    }

    public static int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                ListNode temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }

        return 0;
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCyclePosition(ListNode head) {
        int length = lengthCycle(head);
        if(length == 0) return null;

        ListNode f = head;
        ListNode s = head;

        while(length > 0){
            s = s.next;
            length--;
        }

        while(f!=s){
            s=s.next;
            f=f.next;
        }
        return f;
    }

    //https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if(slow == 1) return true;
        return false;
    }

    private int findSquare(int number){
        int ans =0;
        while(number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number = number/10;
        }
        return ans;
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1=list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2=list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;

        return head.next;
    }

}
