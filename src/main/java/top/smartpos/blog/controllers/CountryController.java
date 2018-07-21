package top.smartpos.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.smartpos.blog.beans.domains.CountryDomain;
import top.smartpos.blog.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/list")
    public List<CountryDomain> list() {
        return countryService.list();
    }

    @GetMapping("/findById")
    public CountryDomain fineById() {
        return countryService.findById();
    }
}
