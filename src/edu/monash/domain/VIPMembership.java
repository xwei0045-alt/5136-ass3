package edu.monash.domain;

import java.time.LocalDate;

/** VIP membership (simple version for US-01: read-only). */
public class VIPMembership {
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;   // null if none
    private String status;       // ACTIVE/EXPIRED/NONE

    public VIPMembership(String email, LocalDate startDate, LocalDate endDate, String status){
        this.email=email; this.startDate=startDate; this.endDate=endDate; this.status=status;
    }
    public String getEmail(){ return email; }
    public LocalDate getStartDate(){ return startDate; }
    public LocalDate getEndDate(){ return endDate; }
    public String getStatus(){ return status; }
}
