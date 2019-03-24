package my.learn.tinyioc;

import my.learn.tinyioc.beans.BeanDefinition;
import my.learn.tinyioc.beans.factory.AbstractBeanFactory;
import my.learn.tinyioc.beans.factory.AutowireCapableBeanFactory;
import my.learn.tinyioc.beans.io.ResourceLoader;
import my.learn.tinyioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by zhu on 2019/3/21.
 */
public class BeanFactoryTest {

    @Test
    public void testLazy() throws Exception {
        // 读取配置
        ResourceLoader resourceLoader = new ResourceLoader();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(resourceLoader);
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 读取配置
        ResourceLoader resourceLoader = new ResourceLoader();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(resourceLoader);
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 初始化bean
        beanFactory.preInstantiateSingletons();

        // 获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
