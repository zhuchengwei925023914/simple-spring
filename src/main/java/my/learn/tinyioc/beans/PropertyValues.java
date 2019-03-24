package my.learn.tinyioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * bean所有属性
 * Created by zhu on 2019/3/21.
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
