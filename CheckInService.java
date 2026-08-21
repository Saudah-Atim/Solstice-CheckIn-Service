import java.util.HashSet;
import java.util.Set;

class CheckInService {

    static Set<String> checkedInAttendees = new HashSet<>();
    static Set<String> pendingAttendees = new HashSet<>();

    public static void checkIn(String attendeeId, String attendeeName) {

        if (checkedInAttendees.contains(attendeeId)
                || pendingAttendees.contains(attendeeId)) {

            System.out.println(attendeeName
                    + " is already checked in or pending. No second badge.");
            return;
        }

        System.out.println("Scanning: " + attendeeName + " (" + attendeeId + ")");

        pendingAttendees.add(attendeeId);

        System.out.println(attendeeName
                + " PENDING - print request sent to message queue.");
    }

    public static void printerWebhook(String attendeeId, String attendeeName) {

        if (!pendingAttendees.contains(attendeeId)) {
            System.out.println("No pending print request found for " + attendeeId);
            return;
        }

        pendingAttendees.remove(attendeeId);
        checkedInAttendees.add(attendeeId);

        System.out.println("Webhook received: " + attendeeName + " CHECKED IN");
    }

    public static void main(String[] args) {

        checkIn("ATT1001", "Saudah");
        checkIn("ATT1002", "Mercy");
        checkIn("ATT1003", "John");

        System.out.println();

        printerWebhook("ATT1002", "Mercy");
        printerWebhook("ATT1001", "Saudah");
        printerWebhook("ATT1003", "John");

        System.out.println();

        checkIn("ATT1001", "Saudah");
    }
}