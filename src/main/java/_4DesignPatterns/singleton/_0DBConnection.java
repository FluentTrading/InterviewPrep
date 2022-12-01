package _4DesignPatterns.singleton;

public class _0DBConnection {

    private final String dbUrl;

    public _0DBConnection( String dbUrl ){
        this.dbUrl = dbUrl;
        System.out.println("_0DBConnection const called.");
    }

    public void connect(){
        System.out.println("Made connection to " + dbUrl );
    }


    public void close(){
        System.out.println("Connection closed.");
    }


}
