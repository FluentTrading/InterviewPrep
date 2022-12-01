package com.interview.arrays;

public class FirstBadVersion {

    //Linear Scan
    public int firstBadVersion( String[] versions ){

        int firstBadVersion = -1;

        for( int i=versions.length; i>=0; i-- ){
            boolean isGood = "Good".equals( versions[i] );
            if( isGood ){
                firstBadVersion = i+1;
                break;
            }
        }

        return firstBadVersion;

    }



    public int firstBadVersionBinarySearch( String[] versions ){
        int start = 1;
        int end = versions.length;

        while( start < end ){
            int mid = start + (end-start) / 2;
            if( "Good".equals(versions[mid]) ){
                start = mid + 1;
            }else {
                end = mid;
            }

        }

        return start;
    }


    public static void main(String[] args) {
        FirstBadVersion v = new FirstBadVersion();
        v.firstBadVersion( new String[]{"Good", "Good", "Bad", "Bad", "Bad"} );
    }

}
