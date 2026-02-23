public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        String body = safe(n.body);
        String subject = safe(n.subject);
        String email = safe(n.email);
        if(body.length() > 40){
            System.out.println("EMAIL WARNING: body truncated to 40 chars");
        }
        System.out.println("EMAIL -> to=" + email + " subject=" + subject + " body=" + body);
        audit.add("email sent");
    }
}
