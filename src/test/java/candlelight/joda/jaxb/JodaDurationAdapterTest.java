package candlelight.joda.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.Duration;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class JodaDurationAdapterTest extends BaseJodaAdapterTest{

    @Test
    public void testMarshalUnmarshal() throws Exception {
        final Duration EXPECTED = new Duration(20L);
        final DurationTest in = new DurationTest(EXPECTED);
        final DurationTest out = marshalUnmarshal(in);

        assertEquals(EXPECTED, out.duration);

    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class DurationTest {

        @XmlJavaTypeAdapter(JodaDurationAdapter.class)
        private Duration duration;

        public DurationTest(Duration duration) {
            this.duration = duration;
        }

        public DurationTest() {
        }
    }
}