package candlelight.joda.jaxb;

import candlelight.joda.jaxb.JodaIntervalAdapter.IntervalHolder;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.Interval;

/**
 *
 */
public class JodaIntervalAdapter extends XmlAdapter<IntervalHolder, Interval> {

    @Override
    public Interval unmarshal(IntervalHolder v) throws Exception {
        return v.toInterval();
    }

    @Override
    public IntervalHolder marshal(Interval v) throws Exception {
        return IntervalHolder.valueOf(v);
    }

    @XmlType(name = "interval")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class IntervalHolder implements Serializable {

        @XmlValue
        private String interval;

        public IntervalHolder() {
        }

        private IntervalHolder(String interval) {
            this.interval = interval;
        }

        public Interval toInterval() {
            return Interval.parse(interval);
        }

        public static IntervalHolder valueOf(Interval i) {
            return new IntervalHolder(i.toString());
        }
    }
}
