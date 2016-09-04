package ru.feech;

import org.anystub.Base;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kirill on 9/4/2016.
 */
public class WorkerEasyTest {

    SourceSystem sourceSystem;

    @Before
    public void createStub()
    {
        Base base = new Base();
        base.init();
        sourceSystem = new SourceSystem("http://localhost:8080") {
            @Override
            public String get() throws IOException {
                return base.request(() -> super.get(), "root");
            }
        };
    }

    @Test
    public void xTest() throws IOException {

        Worker worker = new Worker(sourceSystem);
        assertEquals("fixed", worker.get());
    }

}