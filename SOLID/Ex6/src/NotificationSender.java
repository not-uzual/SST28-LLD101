public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract void send(Notification n);

    protected String safe(String s){ 
        return s == null ? "" : s;
    }
}
