package com.rider.folly.json.types;

import com.rider.folly.json.enums.InstructionReportErrorCode;
import com.rider.folly.json.enums.InstructionReportStatus;

/**
 *
 * @author Ciaron Rider
 */
public class ReplaceInstructionReport {
    /**
     * Whether the command succeeded or failed
     */
    private InstructionReportStatus status;

    /**
     * Cause of failure, or null if command succeeds
     */
    private InstructionReportErrorCode errorCode;

    /**
     * Cancelation report for the original order
     */
    private CancelInstructionReport cancelInstructionReport;

    /**
     * Placement report for the new order
     */
    private PlaceInstructionReport placeInstructionReport;

    public CancelInstructionReport getCancelInstructionReport() {
        return cancelInstructionReport;
    }

    public InstructionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public PlaceInstructionReport getPlaceInstructionReport() {
        return placeInstructionReport;
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

        builder.append(indentString).append("Status                    : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Error Code                : ").append(getErrorCode()).append('\n');

        if (getCancelInstructionReport() == null) {
            builder.append(indentString).append("Cancel Instruction Report : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Cancel Instruction Report : ").append('\n').append(getCancelInstructionReport().toString(indent + Indent.INDENT_SIZE));
        }

        if (getPlaceInstructionReport() == null) {
            builder.append(indentString).append("Place Instruction Report  : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Place Instruction Report  : ").append('\n').append(getPlaceInstructionReport().toString(indent + Indent.INDENT_SIZE));
        }

        return builder.toString();
    }
}
