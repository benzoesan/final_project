//package pl.coderslab.applicationtomanagetheclaimsprecess.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import pl.coderslab.applicationtomanagetheclaimsprecess.repository.ComplaintRepository;
//
//@Controller
//@RequiredArgsConstructor
//public class HomeController {
//
//    private final ComplaintRepository complaintRepository;
//    @GetMapping("/home")
//    public String home(Model model) {
//        model.addAttribute("complaints", complaintRepository.findAll());
//        return "complaint/list";
//    }
//
//    @GetMapping("/about")
//    @ResponseBody
//    public String about() { return "Here you can find some details for logged users"; }
//}
