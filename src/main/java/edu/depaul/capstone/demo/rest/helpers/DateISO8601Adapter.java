package edu.depaul.capstone.demo.rest.helpers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tomislav S. Mitic on 1/24/15.
 */
public class DateISO8601Adapter extends XmlAdapter<String, Date> {

    private static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSZZ";
    private SimpleDateFormat dateFormat;

    public DateISO8601Adapter() {
        super();

        dateFormat = new SimpleDateFormat(ISO_8601_DATE_FORMAT);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }
}
