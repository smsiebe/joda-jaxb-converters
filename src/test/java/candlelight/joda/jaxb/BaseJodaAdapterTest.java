
package candlelight.joda.jaxb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;

/**
 *
 */
public abstract class BaseJodaAdapterTest {

    
    <T> T marshalUnmarshal(T instance) throws Exception {
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream();) {
            JAXBContext jc = JAXBContext.newInstance(instance.getClass());
            jc.createMarshaller().marshal(instance, bout);
            byte[] bytes = bout.toByteArray();
            try (ByteArrayInputStream bin = new ByteArrayInputStream(bytes)) {
                return (T) jc.createUnmarshaller().unmarshal(bin);
            }
        }
    }
}
