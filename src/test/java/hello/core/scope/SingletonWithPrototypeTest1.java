package hello.core.scope;

import hello.core.scope.PrototypeTest.PrototypeBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototypeTest1 {


    @Test
    void singletonClientUsePrototype() {

        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, prototypeBean.class);

        ClientBean ClientBean1 = ac.getBean(ClientBean.class);
        int count1 = ClientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean ClientBean2 = ac.getBean(ClientBean.class);
        int count2 = ClientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(2);
    }


    static class ClientBean {

        //@Autowired
        //prototypeBeanProvider스프링진영
       // private ObjectProvider<prototypeBean> prototypeBeanProvider;

        //자바포준
        @Autowired
        private Provider<prototypeBean> provider;
        public int logic() {
            //prototypeBeanProvider.getObject를 통해서 항상 새로운 프로토타입빈이 생성
            prototypeBean prototypeBean =  provider.get();
            prototypeBean.addCCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class prototypeBean {

       private int count = 0;

        public void addCCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("prototypeBean.close");
        }
    }
}
