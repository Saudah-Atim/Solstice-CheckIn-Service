Solstice Check-In Service — Check-In Prototype  
[Click here to open the live Solstice Check-In Service] https://solstice-checkin-service.onrender.com

This prototype demonstrates a simple check-in process where badge printing is completed before an attendee is fully checked in.

When an attendee scans their QR code, they are placed in a PENDING state instead of being immediately marked as checked in. A print request is simulated, and once the printer completes the job, a simulated webhook confirms the print and the attendee is moved to CHECKED IN.

The service also prevents duplicate badge printing by rejecting scans for attendees who are already PENDING or CHECKED IN.

Webhook confirmations can arrive out of order without affecting the final check-in result.
