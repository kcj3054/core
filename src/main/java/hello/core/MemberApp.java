package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//CTRL + ALT + V
public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl();
//        MemberService memberService = appConfig.memberService();

        //applicationContext를 스프링컨테이너라고 한다
        //스프링컨테이너에는 Bean 저장소가 있다 Bean이름은 메서드 이름으로한다 ,
        // return 객체는 bean 객체로 한다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
