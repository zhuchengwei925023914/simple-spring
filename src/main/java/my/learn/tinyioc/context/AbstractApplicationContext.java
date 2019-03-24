package my.learn.tinyioc.context;

import my.learn.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * Created by zhu on 2019/3/24.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory abstractBeanFactory) {
        this.beanFactory = abstractBeanFactory;
    }

    protected void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
