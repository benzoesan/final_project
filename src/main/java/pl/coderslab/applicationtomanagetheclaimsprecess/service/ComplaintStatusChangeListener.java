package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;

public interface ComplaintStatusChangeListener {
    void onComplaintStatusChanged(Complaint complaint, String oldStatus, String newStatus);
}
