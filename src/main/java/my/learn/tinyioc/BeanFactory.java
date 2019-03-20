package my.learn.tinyioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhu on 2019/3/21.
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
