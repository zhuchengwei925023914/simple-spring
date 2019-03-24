package my.learn.tinyioc.beans.factory;

import my.learn.tinyioc.beans.BeanDefinition;
import my.learn.tinyioc.BeanReference;
import my.learn.tinyioc.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * 可自动装配内容的BeanFactory
 * Created by zhu on 2019/3/21.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        // 开始创建bean时打标记,用来进行循环依赖检查
        beanDefinition.setIsCreating(true);
        // 创建bean实例
        Object bean = createBeanInstance(beanDefinition);
        // 提前暴露bean否则在存在循环依赖的情况下会产生栈溢出
        beanDefinition.setBean(bean);
        // 给bean实例设置属性值
        applyProperties(bean, beanDefinition);
        beanDefinition.setIsCreating(false);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyProperties(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            // 利用反射给字段设置
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
