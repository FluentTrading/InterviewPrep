import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class OneLiners {

    private List<Integer> list = List.of(4, 5, 10);

    public int midAvoidOverflow( int start, int end ) {
        return start + (end - start) / 2;
    }

    public int roundUsingBigDecimal( int radius ){
        BigDecimal value = new BigDecimal(Math.PI * radius * radius);
        value = value.setScale(0, RoundingMode.CEILING);
        return value.intValue();
    }

    public void sumList() {
        list.stream().mapToInt(Integer::intValue).sum();
    }

    public void readFromSystemIn(){
        Scanner console = new Scanner(System.in);
        while( console.hasNext() ){
            String line = console.nextLine();
        }

        console.close();
    }

    private void replaceAllSpaces( String word ){
        //1) Replace all spaces from a word
        word.replaceAll("\\s+", "");
    }

    private void fill2DArrayWithValue( int[][] array, int value ){
        Arrays.stream(array).forEach(a -> Arrays.fill(a, value));
    }

    public void removeFromCollection() {
        List<Integer> list = new ArrayList<>( List.of(10, 5, 20, 30, 40));
        System.out.println("Original list: " + list );
        list.removeIf(val -> (val > 15) );
        System.out.println( "After removal (val >15): "+ list);
    }


    private String printWithDelimiter( List<String> inputList ){
        return String.join("->", inputList);
    }

    //Chunk array of size k
    public static void chunkArray( int k, int[] nums ){
        for( int i=0; i<nums.length; i++ ){
            System.out.print( nums[i] );

            //Ensures we have at least k element remaining in the array.
            if( (nums.length - i) >= k ){
                for( int j = i + 1; j < (i + k); j++ ){
                    System.out.print( nums[j] );
                }
            }
        }
    }

    public static void bigDecimalForCurrency( ){
        int scale = 4;
        double value = 0.11111;
        BigDecimal tempBig = new BigDecimal(Double.toString(value) ).setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        String strValue = tempBig.stripTrailingZeros().toPlainString();
        System.out.println("Value = " + strValue);
    }


    public static void swapTwoNumbers( int one, int sec){
        System.out.println("First: " + one + ", Second: " + sec );
        //No overflow
        one ^= sec;
        sec ^= one;
        one ^= sec;
        System.out.println("Swapped: First: " + one + ", Second: " + sec );
    }

    public static void main(String[] args) {
        OneLiners one = new OneLiners();
        one.swapTwoNumbers(10, 17);
    }
}
