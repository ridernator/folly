package com.rider.folly.json.types;

import com.rider.folly.json.enums.ExecutionReportErrorCode;
import com.rider.folly.json.enums.ExecutionReportStatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ciaron Rider
 */
public class ReplaceExecutionReport {
    /**
     * Echo of the customerRef if passed.
     */
    private String customerRef;

    /**
     *
     */
    private ExecutionReportStatus status;

    /**
     *
     */
    private ExecutionReportErrorCode errorCode;

    /**
     * Echo of marketId passed
     */
    private String marketId;

    /**
     *
     */
    private List<ReplaceInstructionReport> instructionReports;

    public String getCustomerRef() {
        return customerRef;
    }

    public ExecutionReportErrorCode getErrorCode() {
        return errorCode;
    }

    public List<ReplaceInstructionReport> getInstructionReports() {
        if (instructionReports == null) {
            instructionReports = new ArrayList<>();
        }

        return instructionReports;
    }

    public String getMarketId() {
        return marketId;
    }

    public ExecutionReportStatus getStatus() {
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

        builder.append(indentString).append("Customer Ref        : ").append(getCustomerRef()).append('\n');
        builder.append(indentString).append("Status              : ").append(getStatus()).append('\n');
        builder.append(indentString).append("Error Code          : ").append(getErrorCode()).append('\n');
        builder.append(indentString).append("Market Id           : ").append(getMarketId()).append('\n');

        builder.append(indentString).append("Instruction Reports : ").append('\n');

        for (final ReplaceInstructionReport replaceInstructionReport : getInstructionReports()) {
            builder.append(replaceInstructionReport.toString(indent + Indent.INDENT_SIZE)).append('\n');
        }

        return builder.toString();
    }
}
