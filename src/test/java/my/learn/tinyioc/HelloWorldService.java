package my.learn.tinyioc;

/**
 * Created by zhu on 2019/3/21.
 */
public class HelloWorldService {

    private String text;

    private OutputService outputService;

    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
