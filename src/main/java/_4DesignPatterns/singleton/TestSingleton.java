package _4DesignPatterns.singleton;

public class TestSingleton {

    public static void main(String[] args) {
        DemoSingleton.getInstance().connect();
        DemoSingleton.getInstance().close();

        DemoSingleton.getInstance().connect();
        DemoSingleton.getInstance().close();
    }

}
