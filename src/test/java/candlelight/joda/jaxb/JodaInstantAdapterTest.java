package candlelight.joda.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.Instant;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class JodaInstantAdapterTest extends BaseJodaAdapterTest {

    @Test
    public void testMarshalUnmarshal() throws Exception {
        final Instant EXPECTED = new Instant();
        final InstantTest in = new InstantTest(EXPECTED);
        final InstantTest out = marshalUnmarshal(in);

        assertEquals(EXPECTED, out.instant);

    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class InstantTest {

        @XmlJavaTypeAdapter(JodaInstantAdapter.class)
        private Instant instant;

        public InstantTest(Instant instant) {
            this.instant = instant;
        }

        public InstantTest() {
        }
    }
}
