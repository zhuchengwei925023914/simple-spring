package my.learn.tinyioc;

/**
 * Bean的属性
 * Created by zhu on 2019/3/21.
 */
public class PropertyValue {

    // 静态成员变量要么在声明时就初始化,
    // 要么在构造器中初始化
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
