package my.learn.tinyioc;

import my.learn.tinyioc.factory.AutowireCapableBeanFactory;
import my.learn.tinyioc.factory.BeanFactory;
import org.junit.Test;

/**
 * Created by zhu on 2019/3/21.
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        // 初始化beanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("my.learn.tinyioc.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
