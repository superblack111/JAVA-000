package top.yiwenlong.spring01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Spring01Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        XMLConfigBean xm01 = context.getBean("xml01", XMLConfigBean.class);
        xm01.hello();
        log.info("---------------------------------------------------------\n");

    }

}
