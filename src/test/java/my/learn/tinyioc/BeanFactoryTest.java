package my.learn.tinyioc;

import my.learn.tinyioc.factory.AutowireCapableBeanFactory;
import my.learn.tinyioc.factory.BeanFactory;
import org.junit.Test;

/**
 * Created by zhu on 2019/3/21.
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 初始化beanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 定义bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("my.learn.tinyioc.HelloWorldService");

        // 设置属性
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue propertyValue = new PropertyValue("text", "Hello World");
        propertyValues.addPropertyValue(propertyValue);
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
