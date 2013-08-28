package candlelight.joda.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class JodaDateTimeAdapterTest extends BaseJodaAdapterTest{
    
    @Test
    public void testMarshalUnmarshal() throws Exception {
        final DateTime EXPECTED = new DateTime();
        final DateTimeTest in = new DateTimeTest(EXPECTED);
        final DateTimeTest out = marshalUnmarshal(in);

        assertEquals(EXPECTED, out.dateTime);

    }


    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class DateTimeTest {

        @XmlJavaTypeAdapter(JodaDateTimeAdapter.class)
        private DateTime dateTime;

        public DateTimeTest() {
        }

        public DateTimeTest(DateTime dateTime) {
            this.dateTime = dateTime;
        }
    }
}