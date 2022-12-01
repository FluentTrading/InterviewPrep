package com.interview.linkedlist;

import java.util.*;
import com.interview.util.ListNode;

public class ReorderList {

    //Input: [1] -> [2] -> [3] -> [4]
    //Return [1] -> [4] -> [2] -> [3]
    //Put all the nodes in a list and then pick from front and back

    public void reorderList( ListNode head ){

        List<ListNode> list = new ArrayList<>();
        while( head != null ){
            list.add( head );
            head = head.getNext();
        }

        // [0] => [1], [2], [3], [4]
        // [1] => [2], [3], [4]
        // [2] => [3], [4]
        // [3] => [4]
        int low = 0;
        int high = list.size()-1;

        ListNode dummy = new ListNode(-1);
        while( low <= high ){
            dummy.setNext(list.get(low++));
            dummy = dummy.getNext();

            dummy.setNext(list.get(high--));
            dummy = dummy.getNext();
        }

        dummy.setNext(null);// eliminate the cycle

    }


}
