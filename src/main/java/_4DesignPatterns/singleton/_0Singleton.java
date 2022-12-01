package _4DesignPatterns.singleton;

public enum _0Singleton {

    INSTANCE ( _0ConfigManager.getDBUrl() );

    private final _0DBConnection connection;

    _0Singleton( String dbUrl ){
        this.connection = new _0DBConnection( dbUrl );
    }

    public static _0DBConnection getInstance( ){
        return INSTANCE.connection;
    }

}
