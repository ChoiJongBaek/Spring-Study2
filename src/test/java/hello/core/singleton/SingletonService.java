package hello.core.singleton;

public class SingletonService {

    // static의 영향으로 해당 클래스 내에 하나만 존재
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호춞");
    }

}
