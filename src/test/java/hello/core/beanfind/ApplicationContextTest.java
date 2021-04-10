package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    //AnnotationConfigApplicationContext
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출려하기")
    void findBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object  = " + bean);
        }
    }
//    복사 ctrl + d
    @Test
    @DisplayName("애플리케이션 빈 출력하기 ")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
           BeanDefinition beanDefinition =  ac.getBeanDefinition(beanDefinitionName);

           //ROLE_APPLICATION 직접 등록한 애플리케이셔 빈
            // 스프링 내부에서 사용하는 빈
           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
               Object bean = ac.getBean(beanDefinitionName);
               System.out.println("name = " + beanDefinitionName + " object  = " + bean);
           }
        }
    }
}