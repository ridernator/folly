package com.rider.folly.json.types;

import com.rider.folly.json.enums.InstructionReportErrorCode;
import com.rider.folly.json.enums.InstructionReportStatus;

/**
 *
 * @author Ciaron Rider
 */
public class UpdateInstructionReport {
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
    private UpdateInstruction instruction;

    public InstructionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public UpdateInstruction getInstruction() {
        return instruction;
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

        for (int indentIndex = 0; indentIndex < indent; indentIndex++) {
            indentString += ' ';
        }

        builder.append(indentString).append("Status      : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Error Code  : ").append(getErrorCode()).append('\n');

        if (getInstruction() == null) {
            builder.append(indentString).append("Instruction : ").append("Not Set").append('\n');
        } else {
            builder.append(indentString).append("Instruction : ").append('\n').append(getInstruction().toString(indent + Indent.INDENT_SIZE));
        }

        return builder.toString();
    }
}
