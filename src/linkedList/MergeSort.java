package linkedList;

public class MergeSort {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left,right);

    }
    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode midPrev = null;//getting previousmid thats why starting from null

        while(f!=null && f.next!=null){
            f = f.next.next;
            midPrev = midPrev==null? head :  midPrev.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

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
