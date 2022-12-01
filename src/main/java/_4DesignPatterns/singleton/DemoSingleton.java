package _4DesignPatterns.singleton;

public enum DemoSingleton {

    INSTANCE ( DemoConfigManager.getDBUrl() );

    private final DemoDBConnection connection;

    DemoSingleton(String dbUrl ){
        this.connection = new DemoDBConnection( dbUrl );
    }

    public static DemoDBConnection getInstance( ){
        return INSTANCE.connection;
    }

}
