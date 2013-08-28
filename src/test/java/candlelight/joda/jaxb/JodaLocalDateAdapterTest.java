package candlelight.joda.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.LocalDate;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 */
public class JodaLocalDateAdapterTest extends BaseJodaAdapterTest {

    @Test
    public void testMarshalUnmarshal() throws Exception {
        final LocalDate EXPECTED = new LocalDate();
        final LocalDateTest in = new LocalDateTest(EXPECTED);
        final LocalDateTest out = marshalUnmarshal(in);

        assertEquals(EXPECTED, out.localDate);

    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class LocalDateTest {

        @XmlJavaTypeAdapter(JodaLocalDateAdapter.class)
        private LocalDate localDate;

        public LocalDateTest(LocalDate localDate) {
            this.localDate = localDate;
        }

        public LocalDateTest() {
        }
    }
}
