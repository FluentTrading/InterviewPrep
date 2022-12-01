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
    /**
     *  "John"   => "johnsmith@mail.com",    "john_newyork@mail.com"
     *  "John"   => "johnsmith@mail.com",    "john00@mail.com"
     *  "Mary"   => "mary@mail.com"
     *  "John"   => "johnnybravo@mail.com"
     */

    public List<List<String>> accountsMerge( List<List<String>> accounts ) {

        UF dsu = new UF(accounts.size());
        Map<String, Integer> emailToNameId = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) { //j=0 has Name, not email

                String email = accounts.get(i).get(j);
                int currentNameId = i;
                if (emailToNameId.containsKey(email)) {
                    int oldMapNameId = emailToNameId.get(email); // same email with different name or entries
                    dsu.union(oldMapNameId, currentNameId);
                } else {
                    emailToNameId.put(email, currentNameId);
                }
            }
        }

        //johnEmail1 -> 0
        //johnEmail2 -> 0
        //marryEmail -> 2
        //combine these 1&2
        Map<Integer, TreeSet> idToEmailMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int rootParent = dsu.find(i); //p[0] -> 1
            List<String> email = accounts.get(i);
            idToEmailMap.putIfAbsent(rootParent, new TreeSet<>()); // emails of 0 and 1 will come under parent 1
            idToEmailMap.get(rootParent).addAll(email.subList(1, email.size()));
        }

        List<List<String>> res = new LinkedList<>();
        for (int id : idToEmailMap.keySet()) {
            String name = accounts.get(id).get(0);
            List<String> emails = new LinkedList<>(idToEmailMap.get(id));
            emails.add(0, name);
            res.add(emails);
        }

        return res;

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
