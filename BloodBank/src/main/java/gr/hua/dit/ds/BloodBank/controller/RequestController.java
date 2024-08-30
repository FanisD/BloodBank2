package gr.hua.dit.ds.BloodBank.controller;

import gr.hua.dit.ds.BloodBank.entity.Request;
import gr.hua.dit.ds.BloodBank.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("")
    public String showRequests(Model model, Principal principal){
        model.addAttribute("requests", requestService.getRequests());
        String name = principal.getName();
        return "requests";
    }

    @GetMapping("/new")
    public String addRequest(Model model){
        Request request = new Request();
        model.addAttribute("request", request);
        return "add_request";
    }

    @GetMapping("{request_id}")
    public String editRequest(@PathVariable Integer request_id, Model model){
        Request request = requestService.getRequest(request_id);
        model.addAttribute("request", request);
        return "add_request";
    }

    @PostMapping("/new")
    public String saveRequest(Request request, Model model, Principal principal){
        if(request.getStatus() == null){
            request.setStatus("Not Checked");
        }
        if(!request.getLastDonationDate().equals("")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(request.getLastDonationDate(), formatter);
            LocalDate currentDate = LocalDate.now();
            long daysBetween = ChronoUnit.DAYS.between(parsedDate, currentDate);
            if(daysBetween > 112){
                request.setReady(true);
            }else{
                request.setReady(false);
            }
        }
        if(request.getUserEmail().equals("")){
            request.setUserEmail(principal.getName());
        }
        requestService.saveRequest(request);
        model.addAttribute("requests", requestService.getRequests());
        return "requests";
    }


    @DeleteMapping("{request_id}")
    public String deleteRequest(@PathVariable Integer request_id){
        requestService.deleteRequest(request_id);
        return "requests";
    }



}
