package my.learn.tinyioc;


import org.junit.Assert;

/**
 * Created by zhu on 2019/3/23.
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text) {
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
