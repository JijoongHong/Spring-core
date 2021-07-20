package hello.core.singleton;

public class SingletonService {

    //static 영역에 객체를 1개만 생성
    public static final SingletonService instance = new SingletonService();

    // static메소드로만 인스턴스 조회 허용
    public static SingletonService getInstance(){
        return instance;
    }

    // private constructor로 외부에서 생성 불가능
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
