package my.learn.tinyioc;

import org.junit.Test;

/**
 * Created by zhu on 2019/3/21.
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        // 初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
