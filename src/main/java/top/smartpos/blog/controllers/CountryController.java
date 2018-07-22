package top.smartpos.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.smartpos.blog.beans.domains.CountryDomain;
import top.smartpos.blog.beans.models.CountryModel;
import top.smartpos.blog.services.CountryService;
import top.smartpos.blog.utils.SpringUtils;

import javax.validation.Valid;
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

    @GetMapping("/save")
    public Object saveOrUpdate() throws Exception {
        CountryModel countryModel = SpringUtils.validateAndThrow(CountryModel.class);
        return countryService.save(countryModel);
    }
    @GetMapping("/insert")
    public Object insert() throws Exception {
        return countryService.insert();
    }
}
