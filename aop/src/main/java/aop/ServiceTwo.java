package aop;

import org.springframework.stereotype.Component;

@Component("ServiceTwo")
public class ServiceTwo {

    public void add(String str) throws Exception{
        System.out.println("ServiceTwo 增:" + str);
        // throw new Exception("一个假的Exception");
    }

    public void del(String str) {
        System.out.println("ServiceTwo 删:" + str);
    }

    public void update(String str) {
        System.out.println("ServiceTwo 改:" + str);
    }

    public void find(String str) {
        System.out.println("ServiceTwo 查:" + str);
    }

}
