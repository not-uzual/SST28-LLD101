package com.example.reports;

/**
 * Proxy: Implements access control, lazy loading, and caching.
 * - Checks user permissions before allowing access
 * - Only creates RealReport when access is granted and display is requested
 * - Caches the RealReport instance for subsequent calls through the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED -> user=" + user.getName()
                    + " role=" + user.getRole()
                    + " report=" + reportId
                    + " classification=" + classification);
            return;
        }
        
        if (realReport == null) {
            realReport = new RealReport(reportId, title, classification);
        }
        
        realReport.display(user);
    }
}
