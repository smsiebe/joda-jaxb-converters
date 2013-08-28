package candlelight.joda.jaxb;

import candlelight.joda.jaxb.JodaDurationAdapter.DurationHolder;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.Duration;

/**
 *
 */
public class JodaDurationAdapter extends XmlAdapter<DurationHolder, Duration> {

    @Override
    public Duration unmarshal(DurationHolder v) throws Exception {
        return v.toDuration();
    }

    @Override
    public DurationHolder marshal(Duration v) throws Exception {
        return DurationHolder.valueOf(v);
    }

    @XmlType(name = "duration")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class DurationHolder implements Serializable {

        @XmlAttribute(name = "timeUnit", required = true)
        private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        @XmlValue
        private long duration;

        public DurationHolder() {
        }

        private DurationHolder(long duration) {
            this.duration = duration;
        }

        public Duration toDuration() {
            return new Duration(timeUnit.toMillis(duration));
        }

        public static DurationHolder valueOf(Duration duration) {
            return new DurationHolder(duration.getMillis());
        }
    }
}
