package com.interview.linkedlist;

import java.util.*;
import com.interview.util.ListNode;

public class SwapNodes {

    public ListNode swapNodes( ListNode head, int k ){

        Map<Integer, Integer> indxToValue = getMap( head );
        int size = indxToValue.size();
        int left = k;
        int right = size-k+1;

        int count = 1;
        ListNode tmp = head;

        while( tmp != null ){

            if( count == left ){
                tmp.setValue(indxToValue.get(right));

            }else if( count == right ){
                tmp.setValue(indxToValue.get(left));
            }

            tmp = tmp.getNext();
            ++count;
        }

        return head;

    }


    public Map<Integer, Integer> getMap( ListNode head ){
        int indx = 1;
        Map<Integer, Integer> map = new HashMap<>();

        ListNode tmp = head;
        while( tmp != null ){
            map.put(indx++, tmp.getValue());
            tmp = tmp.getNext();
        }

        return map;

    }


}
