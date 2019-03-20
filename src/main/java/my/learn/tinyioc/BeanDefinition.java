package my.learn.tinyioc;

/**
 * Created by zhu on 2019/3/21.
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
