public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        String phone = safe(n.phone);
        String body = safe(n.body);
        if (phone.isEmpty() || !phone.startsWith("+")) {
            System.out.println("WA ERROR: phone must start with + and country code");
            audit.add("WA failed");
            return;
        }
        System.out.println("WA -> to=" + phone + " body=" + body);
        audit.add("wa sent");
    }
}
