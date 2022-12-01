package com.interview.linkedlist;

import java.util.*;


public class FlattenNestedListIterator {

    //https://leetcode.com/problems/flatten-nested-list-iterator/

      public interface NestedInteger {
 
          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();
 
          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();
 
          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
    }

    public static class NestedIntegerImpl implements NestedInteger{

        private boolean isInteger;
        private int value;
        private List<NestedInteger> list;

        public NestedIntegerImpl( int value ){
              this( true, value, Collections.emptyList() );
        }

        public NestedIntegerImpl( List<NestedInteger> list ){
            this( false, -1, list );
        }

        public NestedIntegerImpl( boolean isInteger, int value,  List<NestedInteger> list ){
            this.isInteger = isInteger;
            this.value = value;
            this.list = list;
        }

        public boolean isInteger(){
            return isInteger;
        }

        public Integer getInteger(){
            return value;
        }

        public List<NestedInteger> getList(){
            return list;
        }

    }

    
    public static class NestedIterator implements Iterator<Integer> {

        private final Deque<NestedInteger> deque;
        public NestedIterator( List<NestedInteger> nestedList ){
            this.deque = new ArrayDeque<>( nestedList );
        }

        @Override
        public Integer next(){
           return deque.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext(){
            flattenTopElement();
            return !deque.isEmpty();
        }

        private void flattenTopElement( ){

            //If should be while if we need to handle case where top element is null [[], [2, 4]]
            if( !deque.isEmpty() && !deque.peekFirst().isInteger() ){
                List<NestedInteger> nestedList = deque.removeFirst().getList();
                for( int i=nestedList.size()-1; i>= 0; i-- ){
                    deque.addFirst( nestedList.get(i) );
                }
            }
        }


    }


    public static void main( String[] args ){

        NestedInteger five = new NestedIntegerImpl( 5 );
        NestedInteger two = new NestedIntegerImpl( 2 );
        NestedInteger three = new NestedIntegerImpl( 3 );
        NestedInteger four = new NestedIntegerImpl( 4 );
        NestedInteger nested = new NestedIntegerImpl( List.of(four, three, two) );
        NestedInteger one = new NestedIntegerImpl( 1 );


        NestedIterator iter = new NestedIterator( List.of(five,  nested, one) );
        while( iter.hasNext() ){
            System.out.println( iter.next() );
        }
    }

}
