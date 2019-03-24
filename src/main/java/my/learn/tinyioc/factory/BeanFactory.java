package my.learn.tinyioc.factory;

import my.learn.tinyioc.BeanDefinition;

/**
 * Created by zhu on 2019/3/21.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
