package com.zgulde.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Things to note here:
 *
 * - The url path, method names, and thymeleaf templates are all named similarly. While this is not
 *   required by the framework in any way, this is a good way to keep things organized.
 * - Variable names in the methods and variable names in views are the same. Again this isn't
 *   required, but is a good practice that helps in keeping track of what data is being passed where.
 */
@Controller
@SpringBootApplication
public class DemoApplication {

    private final PhoneRepository phoneDao;
    private final CompanyRepository companyDao;
    private final CarrierRepository carrierDao;

    public DemoApplication(PhoneRepository phoneDao, CompanyRepository companyDao, CarrierRepository carrierDao) {
        this.phoneDao = phoneDao;
        this.companyDao = companyDao;
        this.carrierDao = carrierDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Phone> phones = phoneDao.findAll();
        model.addAttribute("phones", phones);
        return "index";
    }

    @GetMapping("/companies/{company}")
    public String phonesForOneCompany(Model model, @PathVariable String company) {
        Company companies = companyDao.findByName(company);
        model.addAttribute("company", companies);
        return "phones-for-one-company";
    }

    @GetMapping("/phones-by-carrier")
    public String phonesByCarrier(Model model) {
        List<Carrier> carriers = carrierDao.findAll();
        model.addAttribute("carriers", carriers);
        return "phones-by-carrier";
    }

    @GetMapping("/carriers-by-phone")
    public String carriersByPhone(Model model) {
        model.addAttribute("phones", phoneDao.findAll());
        return "carriers-by-phone";
    }


    /**
     * Small endpoint that will fill the database with information. There are no links to this, and
     * it should only be visited once, when the database is empty.
     *
     ******************************************************************************************
     * Important!
     *
     * This method should not ever find it's way into a production application, and is used strictly
     * during development. Eventually this could be replaced with something more sophisticated like
     * a .sql script or a method that runs on startup, checks for the development environment and to
     * see if the database is seeded.
     * ****************************************************************************************
     */
    @GetMapping("/seed")
    @ResponseBody
    public String seed() {
        // Create some carriers, companies, and phones
        Carrier tmobile = new Carrier("T-Mobile");
        Carrier sprint = new Carrier("Sprint");
        carrierDao.save(tmobile);
        carrierDao.save(sprint);

        Company motorola = new Company("Motorola");
        Company nokia = new Company("Nokia");
        companyDao.save(motorola);
        companyDao.save(nokia);

        // note that the created company objects are referenced here
        Phone motoRazr = new Phone(399.99, motorola, "Razr");
        Phone nokia8250 = new Phone(199.99, nokia, "8250");
        Phone nokia505 = new Phone(149.99, nokia, "505");
        Phone nokia9210 = new Phone(249.99, nokia, "9210");
        phoneDao.saveAll(Arrays.asList(motoRazr, nokia8250, nokia505, nokia9210));

        // populate the many-to-many relationship
        tmobile.getPhones().add(motoRazr);
        tmobile.getPhones().add(nokia8250);
        carrierDao.save(tmobile);
        sprint.getPhones().add(motoRazr);
        sprint.getPhones().add(nokia505);
        sprint.getPhones().add(nokia9210);
        carrierDao.save(sprint);

        return "Database seeded successfully!";
    }

}
