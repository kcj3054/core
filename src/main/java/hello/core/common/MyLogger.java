package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void Log(String message) {
        System.out.println("[" + uuid +"]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        System.out.println("[" + uuid  + "]" + "requset cope bean create : " + this);
    }
    @PreDestroy
    public void close() {
        System.out.println("[" + uuid  + "]" + "requset cope bean close : " + this);
    }

}
