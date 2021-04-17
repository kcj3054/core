package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

//호출할때마다 객체가 생성된다 아주 안 좋다 => 그래서 싱글톤이 필요하다
// 메모리 낭비가 너무심하다 -> 해당 객체가 하나만 생성하게 되고 공유하도록 하면 된다
public class SingletoneTest {

    @Test
    @DisplayName("스프링 없는 순수한 Di 컨테이너")
    void pureContainer() {
        AppConfig appConfig= new AppConfig();

        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //검증  1 != 2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴 적용한 객체 사용")
    void sinlgetoneServiceTest() {
        SingleToneService singleToneService1 = SingleToneService.getInstance();
        SingleToneService singleToneService2 = SingleToneService.getInstance();

        assertThat(singleToneService1).isSameAs(singleToneService2);
        // same ==  인스턴스가 같은지 비교
        // equal
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        //AppConfig appConfig= new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //검증  1 != 2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
