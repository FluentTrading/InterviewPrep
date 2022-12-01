package _4DesignPatterns.singleton;

public class TestSingleton {

    public static void main(String[] args) {
        _0Singleton.getInstance().connect();
        _0Singleton.getInstance().close();

        _0Singleton.getInstance().connect();
        _0Singleton.getInstance().close();
    }

}
