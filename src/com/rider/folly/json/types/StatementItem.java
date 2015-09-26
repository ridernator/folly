package com.rider.folly.json.types;

import com.rider.folly.json.enums.ItemClass;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Summary of a cleared order.
 *
 * @author Ciaron Rider
 */
public class StatementItem {
    /**
     * An external reference, eg. equivalent to betId in the case of an exchange
     * bet statement item.
     */
    private String refId;

    /**
     * The date and time of the statement item, eg. equivalent to settledData
     * for an exchange bet statement item. (in ISO-8601 format, not translated)
     */
    private Date itemDate;

    /**
     * The amount of money the balance is adjusted by
     */
    private double amount;

    /**
     * Account balance.
     */
    private double balance;

    /**
     * Class of statement item. This value will determine which set of keys will
     * be included in itemClassData
     */
    private ItemClass itemClass;

    /**
     * Key value pairs describing the current statement item. The set of keys
     * will be determined by the itemClass
     */
    private Map<String, String> itemClassData;

    /**
     * Set of fields originally returned from APIv6. Provided to facilitate
     * migration from APIv6 to API-NG, and ultimately onto itemClass and
     * itemClassData
     */
    private StatementLegacyData legacyData;

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public ItemClass getItemClass() {
        return itemClass;
    }

    public Map<String, String> getItemClassData() {
        if (itemClassData == null) {
            itemClassData = new HashMap<>();
        }

        return itemClassData;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public StatementLegacyData getLegacyData() {
        return legacyData;
    }

    public String getRefId() {
        return refId;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(final int indent) {
        final StringBuilder builder = new StringBuilder();
        String indentString = "";

        for (int indentIndex = 0; indentIndex < indent; indentIndex++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Ref Id          : ").append(getRefId()).append('\n');
        builder.append(indentString).append("Item Date       : ").append(getItemDate()).append('\n');
        builder.append(indentString).append("Amount          : ").append(getAmount()).append('\n');
        builder.append(indentString).append("Balance         : ").append(getBalance()).append('\n');
        builder.append(indentString).append("Item Class      : ").append(getItemClass()).append('\n');

        if (getLegacyData() == null) {
            builder.append(indentString).append("Legacy Data     : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Legacy Data     : ").append('\n').append(getLegacyData().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Item Class Data : ").append('\n');

        for (final Map.Entry<String, String> map : getItemClassData().entrySet()) {
            builder.append(indentString).append(indentString).append(map.getKey()).append(" -> ").append(map.getValue()).append('\n');
        }

        return builder.toString();
    }
}
