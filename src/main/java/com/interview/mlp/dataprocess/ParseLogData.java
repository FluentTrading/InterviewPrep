package com.interview.mlp.dataprocess;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class ParseLogData {


    //Period measures the time with days granularity. In other words, there are no hours, minutes, nor seconds.
    //Duration is similar to Period but with much finer granularity of up to nanoseconds.
    //Instant represents offset from Epoch (01-01-1970)

    //2016-08-16 == ISO_LOCAL_DATE  ==> LocalDate localDate = LocalDate.parse(date);
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/MM/yy");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static class LogData{

        private final LocalDate date;
        private final LocalTime time;
        private final String symbol;
        private final BigDecimal price;
        public LogData( LocalDate date, LocalTime time, String symbol, BigDecimal price ){
            this.date = date;
            this.time = time;
            this.symbol= symbol;
            this.price = price;
        }

        public String toString(){
            return symbol + " was " + price + " on " + date + " at " + time;
        }

    }


    private static void operate( Map<String, List<LogData>> dataMap ){
        System.out.println( dataMap );
    }

    private static void process( String[] datas ){
        Map<String, List<LogData>> dataMap = new HashMap<>();

        for( String data : datas ){
            int indx = 0;
            String[] tokens = validate(parse(data,"\\,"), 4);
            LocalDate date  = parseDate( tokens[indx++] );
            LocalTime time  = parseTime( tokens[indx++] );
            String symbol   = tokens[indx++];
            BigDecimal price= parsePrice(tokens[indx++]);

            List<LogData> list = dataMap.getOrDefault(symbol, new ArrayList<>());
            list.add( new LogData(date, time, symbol, price) );

            dataMap.put( symbol, list );
        }

        operate( dataMap);
    }


    public static LocalDate parseDate(String date ){
        return LocalDate.parse(date, INPUT_FORMAT);
    }

    public static LocalTime parseTime(String time ){
        return LocalTime.parse(time);
    }

    public static BigDecimal parsePrice( String price ){
        return new BigDecimal(price);
    }

    public static String[] parse( String data, String delimiter ){
        System.out.println(Arrays.toString(data.split(delimiter)));
        return data.split(delimiter);
    }

    public static String[] validate( String[] tokens, int expectedCount ){
        if( tokens == null || tokens.length != expectedCount) {
            throw new IllegalStateException("Must have " + expectedCount + " tokens");
        }

        return tokens;
    }


    public static void main(String[] args) {
        String[] data = {
                "10/05/22,04:00:00,AAPL,125.97",
                "10/08/22,17:00:00,AAPL,150.50",
                "10/09/22,20:00:00,AAPL,145.20",
                "10/09/22,20:00:00,C,23.20",
                "10/09/22,20:00:00,JPM,57.20",
                "10/09/22,20:00:00,JPM,60.0",
        };

        process( data );

    }


}
