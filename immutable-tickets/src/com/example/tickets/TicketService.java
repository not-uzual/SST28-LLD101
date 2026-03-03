package com.example.tickets;

/**
 * Service layer that creates tickets.
 *
 * FIXED: Uses immutable IncidentTicket + Builder.
 * All validation is centralized in Builder.build().
 * Updates return NEW ticket instances instead of mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {

        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .addTag("NEW")
                .build();
    }

    /**
     * Returns a NEW ticket with CRITICAL priority and ESCALATED tag.
     * Does not mutate the original ticket.
     */
    public IncidentTicket escalateToCritical(IncidentTicket original) {
        return original.toBuilder()
                .priority("CRITICAL")
                .addTag("ESCALATED")
                .build();
    }

    /**
     * Returns a NEW ticket with the assignee set.
     * Does not mutate the original ticket.
     */
    public IncidentTicket assign(IncidentTicket original, String assigneeEmail) {
        return original.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
