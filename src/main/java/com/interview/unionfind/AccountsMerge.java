package com.interview.unionfind;

import java.util.*;

public class AccountsMerge {

    private static class UF {
        private int[] parents;
        private int count;

        public UF( int n ){
            this.count = n;
            this.parents = new int[ n ];

            //Set every node to be its own parent
            for( int i=0; i<n; i++ ){
                parents[i] = i;
            }
        }

        //Combine two disjoint sets into one
        public void union( int edge1, int edge2 ){
            int parent1 = find(edge1 );
            int parent2 = find(edge2 );
            if( parent1 != parent2 ){
                parents[parent1] = parent2;
                --count;
            }
        }


        //Find the parent of the given edge
        public int find( int edge ){
            //If the index == value then we found the parent
            if( edge == parents[edge] ){
                return edge;
            }

            return (parents[edge] = find(parents[edge])); // Path compression
        }

    }


    /**
     *  Given this data, merge accounts.
     *  Two accounts belong to the same person if there is some common email to both accounts.
     *  Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
     *
     *  John  -> "johnsmith@mail.com", "john_newyork@mail.com"
     *  John  -> "johnsmith@mail.com","john00@mail.com"
     *  Mary  -> "mary@mail.com"
     *  John  -> "johnnybravo@mail.com"
     *
     *  Output:
     *  John -> "johnsmith@mail.com", "john_newyork@mail.com", "john00@mail.com"
     *  Mary  -> "mary@mail.com"
     *  John  -> "johnnybravo@mail.com"
     */

    /**
     * Use two hash map with union find class to solve the problem
     * mailToIndex: one to one mapping: mail string to its parent index mapping
     * disjointSet: one to many mapping: parent index to all emails that belong to same group mapping
     * */
    public List<List<String>> accountsMerge( List<List<String>> accounts ){

        int accountSize = accounts.size();
        UF uf = new UF(accountSize);

        // Step 1: traverse all emails except names, if we have not seen an email before, put it with its index into map.
        // Otherwise, union the email to its parent index.
        Map<String, Integer> mailToIndex = new HashMap<>();
        for( int i = 0; i < accountSize; i++ ){
            for( int j = 1; j < accounts.get(i).size(); j++ ){

                String curMail = accounts.get(i).get(j);
                if( mailToIndex.containsKey(curMail) ){
                    int preIndex = mailToIndex.get(curMail);
                    uf.union(preIndex, i);
                }else{
                    mailToIndex.put(curMail, i);
                }
            }
        }

        // Step 2: traverse every email list, find the parent of current list index and put all emails into the set list
        // that belongs to key of its parent index
        Map<Integer, Set<String>> disjointSet = new HashMap<>();
        for( int i = 0; i < accountSize; i++ ){
            // find parent index of current list index in parent array
            int parentIndex = uf.find(i);
            disjointSet.putIfAbsent(parentIndex, new HashSet<>());

            Set<String> curSet = disjointSet.get(parentIndex);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                curSet.add(accounts.get(i).get(j));
            }

            disjointSet.put(parentIndex, curSet);
        }


        // step 3: traverse ket set of disjoint set group, retrieve all emails from each parent index, and then SORT
        // them, as well as adding the name at index 0 of every sublist
        List<List<String>> result = new ArrayList<>();
        for( int index : disjointSet.keySet() ){
            List<String> curList = new ArrayList<>();
            if( disjointSet.containsKey(index) ){
                curList.addAll(disjointSet.get(index));
            }

            Collections.sort(curList);
            curList.add(0, accounts.get(index).get(0));
            result.add(curList);

        }

        return result;
    }


    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add( List.of("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add( List.of("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add( List.of("Mary","mary@mail.com"));
        accounts.add( List.of("John","johnnybravo@mail.com"));

        AccountsMerge acc = new AccountsMerge();
        System.out.println( acc.accountsMerge( accounts ) );
    }


}
