package my.learn.tinyioc.context;

import my.learn.tinyioc.beans.BeanDefinition;
import my.learn.tinyioc.beans.factory.AbstractBeanFactory;
import my.learn.tinyioc.beans.factory.AutowireCapableBeanFactory;
import my.learn.tinyioc.beans.io.ResourceLoader;
import my.learn.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by zhu on 2019/3/24.
 */
public class ClassPathApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathApplicationContext(String configLocation, AbstractBeanFactory abstractBeanFactory) throws Exception {
        super(abstractBeanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    protected void refresh() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(resourceLoader);
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
