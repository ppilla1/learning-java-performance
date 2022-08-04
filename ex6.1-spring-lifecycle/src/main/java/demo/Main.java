package demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j2
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("demo/ApplicationContext.xml");

        Customer cust = (Customer) ctx.getBean("customer");
        log.info("name {}", cust.getName());

        Account acc = (Account) ctx.getBean("account");
        log.info("amount " + acc.amt);
    }

}
