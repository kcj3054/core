package hello.core.autowired;

import hello.core.discount.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {
    @Test
    void findAllBean() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class);
    }

    static  class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy>polices;

        DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> polices, Map<String, DiscountPolicy> map) {
            this.policyMap = policyMap;
            this.polices = polices;
            System.out.println("policyMap " + policyMap);
            System.out.println("polices " + polices);
        }
    }
}
