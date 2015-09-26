package com.rider.folly.json.types;

import com.rider.folly.json.enums.PersistenceType;

/**
 * Instruction to update LIMIT bet's persistence of an order that do not affect
 * exposure
 *
 * @author Ciaron Rider
 */
public class UpdateInstruction {
    /**
     * Unique identifier for the bet
     */
    private String betId;

    /**
     * The new persistence type to update this bet to
     */
    private PersistenceType newPersistenceType;

    public String getBetId() {
        return betId;
    }

    public PersistenceType getNewPersistenceType() {
        return newPersistenceType;
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

        builder.append(indentString).append("Bet Id               : ").append(getBetId()).append('\n');
        builder.append(indentString).append("New Persistence Type : ").append(getNewPersistenceType()).append('\n');

        return builder.toString();
    }
}
