public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        String phone = safe(n.phone);
        String body = safe(n.body);
        System.out.println("SMS -> to=" + phone + " body=" + body);
        audit.add("sms sent");
    }
}
