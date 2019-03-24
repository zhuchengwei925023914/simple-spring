package my.learn.tinyioc.context;

import my.learn.tinyioc.HelloWorldService;
import org.junit.Test;

/**
 * Created by zhu on 2019/3/24.
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathApplicationContext classPathApplicationContext = new ClassPathApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) classPathApplicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}