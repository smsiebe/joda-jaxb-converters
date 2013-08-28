package candlelight.joda.jaxb;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.DateTime;

/**
 *
 */
public class JodaDateTimeAdapter extends XmlAdapter<Date, DateTime> {

    @Override
    public DateTime unmarshal(Date v) throws Exception {
        return new DateTime(v);
    }

    @Override
    public Date marshal(DateTime v) throws Exception {
        return v.toDate();
    }
}
