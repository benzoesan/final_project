package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.ComplaintRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ComplaintService {
    private final ComplaintRepository complaintRepository;

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint createComplaint (Complaint complaint) {
        complaint.setDateOfComplaint(LocalDateTime.now());
        return complaintRepository.save(complaint);
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).get();
    }

    public void updateComplaint(Complaint complaint ){
        complaintRepository.save(complaint);
    }

    public void deleteComplaintById(Long id){
        complaintRepository.deleteById(id);
    }
}
