package your_store.utils;

public class ReportUtils {

    private static final String LINE = "*".repeat(70);
    private static final String START_SUITE_TEST = "************************** START SUITE TEST **************************";

    public static void logLine() {
        LoggerUtils.logInfo(LINE);
    }

    public static final void logStartLine() {
        LoggerUtils.logInfo(START_SUITE_TEST);
    }

    public static final void logReportHeader() {
        LoggerUtils.logInfo(
                "Test Run"
                + "Date: "
        );
    }
}
