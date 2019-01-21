package aop;

import org.springframework.stereotype.Component;

@Component("ServiceOne")
public class ServiceOne {

    public void add(String str) {
        System.out.println("ServiceOne 增:" + str);
    }

    public void del(String str) {
        System.out.println("ServiceOne 删:" + str);
    }

    public void update(String str) {
        System.out.println("ServiceOne 改:" + str);
    }

    public void find(String str) {
        System.out.println("ServiceOne 查:" + str);
    }

}
