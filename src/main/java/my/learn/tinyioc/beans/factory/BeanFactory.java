package my.learn.tinyioc.beans.factory;

import my.learn.tinyioc.beans.BeanDefinition;

/**
 * Created by zhu on 2019/3/21.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
