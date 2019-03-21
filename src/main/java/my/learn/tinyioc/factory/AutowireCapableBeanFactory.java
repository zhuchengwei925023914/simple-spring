package my.learn.tinyioc.factory;

import my.learn.tinyioc.BeanDefinition;

/**
 * Created by zhu on 2019/3/21.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
