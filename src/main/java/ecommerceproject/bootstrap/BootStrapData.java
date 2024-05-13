package ecommerceproject.bootstrap;

import ecommerceproject.dao.CustomerRepository;
import ecommerceproject.dao.DivisionRepository;
import ecommerceproject.entities.Customer;
import ecommerceproject.entities.Division;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData{

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @PostConstruct
    public void loadInitialData() {
       if(customerRepository.count()==1) {
           Division hawaii = divisionRepository.getReferenceById(52L);
           Division england = divisionRepository.getReferenceById(101L);
           Division cali = divisionRepository.getReferenceById(4L);
           Customer santa = new Customer("Santa", "Clause", "1234 North Pole", "98107",
                   "2062845678", hawaii);
           Customer cloudStrife = new Customer("Cloud", "Strife", "1234 Nibelheim Ave", "12345",
                   "2066789635", hawaii);
           Customer adaWong = new Customer("Ada", "Wong", "3421 Undisclosed Ave", "98547",
                   "3256879565", england);
           Customer nathanDrake = new Customer("Nathan", "Drake", "4321 Shuteye Ave", "98654",
                   "2485964777", england);
           Customer alanWake = new Customer("Alan", "Wake", "7431 Writers Ave", "95474",
                   "2584659663", cali);
           Customer aloySobeck = new Customer("Aloy", "Sobeck", "100 Hollywood Boulevard", "89076",
                   "2485963214", england);


           customerRepository.save(santa);
           customerRepository.save(cloudStrife);
           customerRepository.save(adaWong);
           customerRepository.save(nathanDrake);
           customerRepository.save(alanWake);
           customerRepository.save(aloySobeck);
           System.out.println("Sample customers placed in database.");
       }
       else {
           System.out.println("Sample customers already in database.");
       }
    }
}
