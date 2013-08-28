
package candlelight.joda.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.Interval;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class JodaIntervalAdapterTest extends BaseJodaAdapterTest {

    @Test
    public void testMarshalUnmarshal() throws Exception {
        final Interval EXPECTED = new Interval(10L, 20L);
        final IntervalTest in = new IntervalTest(EXPECTED);
        final IntervalTest out = marshalUnmarshal(in);

        assertEquals(EXPECTED, out.interval);

    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class IntervalTest {

        @XmlJavaTypeAdapter(JodaIntervalAdapter.class)
        private Interval interval;

        public IntervalTest(Interval interval) {
            this.interval = interval;
        }

        public IntervalTest() {
        }
    }
}
