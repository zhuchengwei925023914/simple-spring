package my.learn.tinyioc.xml;

import junit.framework.TestCase;
import my.learn.tinyioc.BeanDefinition;
import my.learn.tinyioc.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by zhu on 2019/3/23.
 */
public class XmlBeanDefinitionReaderTest extends TestCase {

    @Test
    public void testLoadBeanDefinitions() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(resourceLoader);
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        assertTrue(registry.size() > 0);
    }
}