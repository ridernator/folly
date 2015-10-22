package com.rider.folly.json.types;

import com.rider.folly.json.enums.InstructionReportErrorCode;
import com.rider.folly.json.enums.InstructionReportStatus;
import java.util.Date;

/**
 * Response to a PlaceInstruction
 *
 * @author Ciaron Rider
 */
public class PlaceInstructionReport {
    /**
     * Whether the command succeeded or failed
     */
    private InstructionReportStatus status;

    /**
     * Cause of failure, or null if command succeeds
     */
    private InstructionReportErrorCode errorCode;

    /**
     * The instruction that was requested
     */
    private PlaceInstruction instruction;

    /**
     * The bet ID of the new bet. May be null on failure.
     */
    private String betId;

    /**
     * The date on which the bet was placed
     */
    private Date placedDate;

    /**
     * The average price matched
     */
    private double averagePriceMatched;

    /**
     * The size matched.
     */
    private double sizeMatched;

    public double getAverageOddsMatched() {
        return averagePriceMatched;
    }

    public String getBetId() {
        return betId;
    }

    public InstructionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public PlaceInstruction getInstruction() {
        return instruction;
    }

    public Date getPlacedDate() {
        return placedDate;
    }

    public double getAmountMatched() {
        return sizeMatched;
    }

    public InstructionReportStatus getStatus() {
        return status;
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

        builder.append(indentString).append("Status                : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Error Code            : ").append(getErrorCode()).append('\n');

        if (getInstruction() == null) {
            builder.append(indentString).append("Instruction           : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Instruction           : ").append('\n').append(getInstruction().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Bet Id                : ").append(getBetId()).append('\n');
        builder.append(indentString).append("Placed Date           : ").append(getPlacedDate()).append('\n');
        builder.append(indentString).append("Average Odds Matched : ").append(getAverageOddsMatched()).append('\n');
        builder.append(indentString).append("Amount Matched          : ").append(getAmountMatched()).append('\n');

        return builder.toString();
    }
}
