package my.learn.tinyioc.xml;

import my.learn.tinyioc.*;
import my.learn.tinyioc.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by zhu on 2019/3/22.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        try (InputStream inputStream = getResourceLoader().getResource(location).getInputStream()) {
            doLoadBeanDefinitions(inputStream);
        }
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        // 解析bean
        registerBeanDefinitions(document);
    }

    private void registerBeanDefinitions(Document document) {
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nodeList = root.getChildNodes();
        int length = nodeList.getLength();
        for (int i = 0; i < length; i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                processBeanDefinition(element);
            }
        }
    }

    private void processBeanDefinition(Element element) {
        String name = element.getAttribute("name");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList propertyNodeList = element.getElementsByTagName("property");
        int length = propertyNodeList.getLength();
        for (int i = 0; i < length; i++) {
            Node node = propertyNodeList.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                if (value != null && value.length() > 0) {
                    PropertyValue propertyValue = new PropertyValue(name, value);
                    propertyValues.addPropertyValue(propertyValue);
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property "
                                + name + " must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    PropertyValue propertyValue = new PropertyValue(name, beanReference);
                    propertyValues.addPropertyValue(propertyValue);
                }
                beanDefinition.setPropertyValues(propertyValues);
            }
        }
    }
}
