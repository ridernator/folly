package com.rider.folly.json.types;

import com.rider.folly.json.enums.CountryCode;
import java.util.Date;

/**
 * Event
 *
 * @author Ciaron Rider
 */
public class Event {
    /**
     * The unique id for the event
     */
    private String id;

    /**
     * The name of the event
     */
    private String name;

    /**
     * The ISO-2 code for the event. A list of ISO-2 codes is available via
     * http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
     */
    private CountryCode countryCode;

    /**
     * This is timezone in which the event is taking place.
     */
    private String timezone;

    /**
     * Venue
     */
    private String venue;

    /**
     * The scheduled start date and time of the event. This is Europe/London
     * (GMT) by default
     */
    private Date openDate;

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(final int indent) {
        final StringBuilder builder = new StringBuilder();
        String indentString = "";

        for (int index = 0; index < indent; index++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Id           : ").append(getId()).append('\n');
        builder.append(indentString).append("Name         : ").append(getName()).append('\n');
        builder.append(indentString).append("Country Code : ").append(getCountryCode()).append('\n');
        builder.append(indentString).append("Timezone     : ").append(getTimezone()).append('\n');
        builder.append(indentString).append("Venue        : ").append(getVenue()).append('\n');
        builder.append(indentString).append("Open Date    : ").append(getOpenDate()).append('\n');

        return builder.toString();
    }
}
