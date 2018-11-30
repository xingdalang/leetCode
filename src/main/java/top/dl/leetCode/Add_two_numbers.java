package top.dl.leetCode;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

public class Add_two_numbers {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例：

     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode a = l1;
            ListNode b = l2;
            int val = 0;
            ListNode re = new ListNode(0);
            ListNode r = re;
            while(a != null || b != null){
                if(a == null){
                    val = val + b.val;
                }else if(b == null){
                    val = val + a.val;
                }else {
                    val = val + a.val + b.val;
                }
                r.next = new ListNode(val%10);
                r = r.next;
                val = val / 10;
                if(a != null){
                    a = a.next;
                }
                if(b != null){
                    b = b.next;
                }
            }
            return re;
        }



    public class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
    }

    @Test
    public void testt(){
            ListNode a = new ListNode(0);
            ListNode b = new ListNode(0);
            ListNode l1 = new ListNode(0);
            ListNode l2 = new ListNode(0);
            ListNode l3 = new ListNode(0);
            ListNode l4 = new ListNode(0);
            ListNode l5 = new ListNode(0);
            ListNode l6 = new ListNode(0);
            ListNode l7 = new ListNode(0);
            ListNode l8 = new ListNode(0);
            ListNode l9 = new ListNode(0);
            a.next=l1;
            l1.next=l3;
            l3.next=l5;
            l5.next=l7;
            l7.next=l9;

            b.next=l2;
            l2.next=l4;
            l4.next=l6;
            l6.next=l8;


        ListNode listNode = addTwoNumbers(a, b);
        System.out.println(JSON.toJSONString(listNode));
    }

}
