package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //long 타입으로 하면 null이 들어 갈 수 있다
        Long memberId = 1L;
        Member member =  new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order =  orderService.CreateOrder(memberId, "memberA", 10000);


        //검증
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}