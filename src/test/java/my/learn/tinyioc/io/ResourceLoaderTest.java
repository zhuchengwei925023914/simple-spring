package my.learn.tinyioc.io;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by zhu on 2019/3/22.
 */
public class ResourceLoaderTest extends TestCase {

    @Test
    public void testGetResource() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        assertNotNull(inputStream);
    }
}