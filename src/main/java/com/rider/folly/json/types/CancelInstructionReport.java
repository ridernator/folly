package com.rider.folly.json.types;

import com.rider.folly.json.enums.InstructionReportErrorCode;
import com.rider.folly.json.enums.InstructionReportStatus;
import java.util.Date;

/**
 *
 * @author Ciaron Rider
 */
public class CancelInstructionReport {
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
    private CancelInstruction instruction;

    private double sizeCancelled;

    private Date cancelledDate;

    public Date getCancelledDate() {
        return cancelledDate;
    }

    public InstructionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public CancelInstruction getInstruction() {
        return instruction;
    }

    public double getAmountCancelled() {
        return sizeCancelled;
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

        builder.append(indentString).append("Status           : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Error Code       : ").append(getErrorCode()).append('\n');

        if (getInstruction() == null) {
            builder.append(indentString).append("Instruction      : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Instruction      : ").append('\n').append(getInstruction().toString(indent + Indent.INDENT_SIZE));
        }

        builder.append(indentString).append("Amount Cancelled : ").append(getAmountCancelled()).append('\n');
        builder.append(indentString).append("Cancelled Date   : ").append(getCancelledDate()).append('\n');

        return builder.toString();
    }
}
