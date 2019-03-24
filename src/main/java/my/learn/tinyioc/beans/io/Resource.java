package my.learn.tinyioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 内部定位资源的接口
 * Created by zhu on 2019/3/22.
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
