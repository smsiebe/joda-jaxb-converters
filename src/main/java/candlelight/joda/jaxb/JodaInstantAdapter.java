package candlelight.joda.jaxb;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.Instant;

/**
 *
 */
public class JodaInstantAdapter extends XmlAdapter<Date, Instant> {

    @Override
    public Instant unmarshal(Date date) throws Exception {
        return new Instant(date);
    }

    @Override
    public Date marshal(Instant instant) throws Exception {
        return instant.toDate();
    }
}
