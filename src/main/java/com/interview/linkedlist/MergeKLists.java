package com.interview.linkedlist;

import com.interview.util.ListNode;
import java.util.PriorityQueue;


public class MergeKLists {

    /*
        Merge these into one sorted list
        [
          1->4->5,
          1->3->4,
          2->6
        ]

        1) Since these are sorted, pick the first element of each Nodes and add to MinHeap:[1, 1, 2]
        2) Pop from the heap (node), add to result
        3) Add the rest of the links from node to the heap
     */

    public ListNode mergeKLists( ListNode[] lists ){

        PriorityQueue<ListNode> minPQ = new PriorityQueue<>((node1, node2) -> node1.getValue() - node2.getValue());
        for ( ListNode node : lists ){
            minPQ.offer( node );
        }

        ListNode result = new ListNode(-1);
        ListNode temp = result;

        while( !minPQ.isEmpty() ){

            //Poll the first node and add it to result
            ListNode curr = minPQ.poll();
            temp.setNext( new ListNode(curr.getValue()));

            //If there are more chains in the node then we add it to the heap
            if( curr.getNext() != null ){
                minPQ.offer(curr.getNext());
            }

            //Move chain
            temp = temp.getNext();
        }

        return result.getNext();

    }


}
