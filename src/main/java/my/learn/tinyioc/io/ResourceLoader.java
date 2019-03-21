package my.learn.tinyioc.io;

import java.net.URL;

/**
 * Created by zhu on 2019/3/22.
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
