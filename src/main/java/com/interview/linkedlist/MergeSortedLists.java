package com.interview.linkedlist;

import util.ListNode;

public class MergeSortedLists {


    public ListNode mergeTwoLists( ListNode list1, ListNode list2 ){

        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        //Iterate over both lists, compare the value and move the smaller value node forward.
        while( list1 != null || list2 != null ){

            if( list1 != null && list2 != null ){
                if( list1.getValue() <= list2.getValue() ){
                    dummy.setNext( new ListNode(list1.getValue()) );
                    list1 = list1.getNext();
                }else{
                    dummy.setNext( new ListNode(list2.getValue()) );
                    list2 = list2.getNext();
                }

            }else if( list1 != null && list2 == null ){
                dummy.setNext( new ListNode(list1.getValue()) );
                list1 = list1.getNext();

            }else if( list1 == null && list2 != null ){
                dummy.setNext( new ListNode(list2.getValue()) );
                list2 = list2.getNext();
            }

            //Move chain along
            dummy = dummy.getNext();
        }

        return result.getNext();

    }

}
