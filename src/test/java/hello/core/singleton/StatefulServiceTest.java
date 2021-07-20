package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread A : A사용자 10000원 주문
        int UserAPrice = statefulService1.order("UserA", 10000);
        //Thread B : B사용자 20000원 주문
        int UserBPrice = statefulService2.order("UserB", 20000);

        //Thread A : A사용자 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + UserAPrice);

        //장애 발생 -> 스프링 빈은 항상 stateless!
        //assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}