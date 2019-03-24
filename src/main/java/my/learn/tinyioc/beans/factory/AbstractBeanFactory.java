package my.learn.tinyioc.beans.factory;

import my.learn.tinyioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhu on 2019/3/21.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    private boolean cycleDependencyCheckSwitch = false;

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }

        // 循环依赖检查
        if (beanDefinition.getIsCreating() && cycleDependencyCheckSwitch) {
            List<String> circularDependencyBeanNames = new ArrayList<>();
            for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : beanDefinitionMap.entrySet()) {
                if (beanDefinitionEntry.getValue().getIsCreating()) {
                    circularDependencyBeanNames.add(beanDefinitionEntry.getKey());
                }
            }
            throw new IllegalArgumentException("Circular dependency exists in " + circularDependencyBeanNames);
        }

        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 预加载bean
     *
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Exception {
        Iterator iterator = beanDefinitionNames.iterator();
        while (iterator.hasNext()) {
            String beanName = (String) iterator.next();
            getBean(beanName);
        }
    }

    public void setCycleDependencyCheckSwitch(boolean cycleDependencyCheckSwitch) {
        this.cycleDependencyCheckSwitch = cycleDependencyCheckSwitch;
    }

    /**
     * 初始化bean
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
