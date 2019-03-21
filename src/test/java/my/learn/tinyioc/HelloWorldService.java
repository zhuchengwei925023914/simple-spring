package my.learn.tinyioc;

/**
 * Created by zhu on 2019/3/21.
 */
public class HelloWorldService {

    private String text;

    public void helloWorld() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
