package linkedList;

import java.util.List;
import java.util.ListResourceBundle;

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

    public static void main(String[] args) {
        LeetCodePrblms obj = new LeetCodePrblms();
        ListNode listHead = new ListNode(1);
        ListNode node = listHead;
        for (int i = 2; i <= 12; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        obj.display(listHead);
        System.out.println();
        listHead = obj.rotateRightOpt(listHead,3);
        obj.display(listHead);

    }


    //https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);
        k=size%k;
        for (int i = 0; i < k; i++) {
            ListNode prev=null;
            ListNode curr=head;
            while(curr.next != null){
                prev = curr;
                curr = curr.next;
            }
            curr.next=head;
            prev.next=null;
            head = curr;
        }

        return head;
    }

    public ListNode rotateRightOpt(ListNode head, int k) {
        int length = 1;
        ListNode curr=head;
        while(curr.next != null){
            curr = curr.next;
            length++;
        }
        curr.next = head;

        int rotations = k % length;
        int skip = length - rotations;
        ListNode skipnNode = head;
        for (int i = 0; i < skip-1; i++) {
            skipnNode=skipnNode.next;
        }
        head = skipnNode.next;
        skipnNode.next=null;
        return head;
    }

    // https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
public ListNode reverseAlternateKGroup(ListNode head, int k){
    int size = getSize(head);
    int parts = size/k;
    for (int i = 1; i <= parts; i++) {
        if(i%2==0) continue;
        int right = i*k;
        if(right > size) break;
        head = reverseBetween(head,right-k+1,right);
        System.out.println();
        display(head);
    }
    return head;
}

    //https://leetcode.com/problems/reverse-nodes-in-k-group
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        int parts = size/k;
        for (int i = 1; i <= parts; i++) {
            int right = i*k;
            if(right > size) break;
           head = reverseBetween(head,right-k+1,right);
            System.out.println();
           display(head);
        }
        return head;
    }


    //https://leetcode.com/problems/reorder-list/
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode midNode = middleNode(head);
        ListNode secondHead = itrReverse(midNode);
        ListNode node = head;

        display(secondHead);
       while(node != null && secondHead != null) {
            ListNode temp = node.next;
            node.next = secondHead;
            node = temp;

            temp= secondHead.next;
            secondHead.next = node;
            secondHead = temp;
        }

        if (node != null) {
            node.next = null;
        }
        System.out.println("---> reordered -->");
        display(head);
    }

    //https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        int size = getSize(head);
        int mid = 1+ (size-1)/2;

        ListNode newHead = reverseBetween(head,mid,size);

        ListNode midNode = middleNode(newHead);
//        for (int i = 1; i < mid; i++) {
//            midNode = midNode.next;
//        }
        for (int i = 1; i < mid; i++) {
            if(newHead.val != midNode.val)
                return false;
            newHead = newHead.next;
            midNode = midNode.next;
        }

        return true;
    }

    void display(ListNode head){
        while (head != null){
            System.out.print(head.val + "-> ");
            head = head.next;
        }
        System.out.print("END");
    }

    int getSize(ListNode head){
        if(head == null) return 0;
        ListNode node = head;
        int length = 0;
        while(node != null){
            node = node.next;
            length++;
        }
        return length;
    }

    //https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode prev = null;
        ListNode curr = head;

        //skip left-1 nodes
        for (int i = 0; curr != null && i < left-1 ; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode last = prev;
        ListNode newEnd = curr;

        // reverse between left and right
        ListNode next = curr.next;
        for (int i = 0; curr != null && i < right - left + 1; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;
        return head;
    }


    //https://leetcode.com/problems/reverse-linked-list
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        if(head == null || head.next == null) return head;
        head = recReverse(null,head,head.next);
        return head;
    }

    ListNode recReverse(ListNode prev,ListNode curr,ListNode next){
        if(next==null) {
            curr.next = prev;
            return curr;
        }
        curr.next = prev;
        prev = curr;
        curr = next;
        next = next.next;
        curr = recReverse(prev,curr,next);
        return curr;
    }

    ListNode itrReverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }

        return prev;
    }

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
