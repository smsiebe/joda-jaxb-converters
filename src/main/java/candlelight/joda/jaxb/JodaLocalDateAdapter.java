package candlelight.joda.jaxb;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.LocalDate;

/**
 *
 */
public class JodaLocalDateAdapter extends XmlAdapter<Date, LocalDate> {

    @Override
    public LocalDate unmarshal(Date date) throws Exception {
        return LocalDate.fromDateFields(date);
    }

    @Override
    public Date marshal(LocalDate localDate) throws Exception {
        return localDate.toDate();
    }
}
