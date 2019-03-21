package my.learn.tinyioc;

/**
 * Created by zhu on 2019/3/21.
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;

    public BeanDefinition() {

    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            // 根据类的全限定名获得Class对象
            beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
