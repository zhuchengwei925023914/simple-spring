package my.learn.tinyioc;

/**
 * 从配置中读取BeanDefinition
 * Created by zhu on 2019/3/22.
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
