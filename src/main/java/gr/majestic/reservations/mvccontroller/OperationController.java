package gr.majestic.reservations.mvccontroller;


import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class OperationController {

   private final CustomerService customerService;

    @GetMapping("edit/{customerId}")
    public String editCustomer(Model model,@PathVariable long customerId){
        Customer customer = customerService.read(customerId);
        model.addAttribute("customer", customer);
        return "edit";
    }

}
