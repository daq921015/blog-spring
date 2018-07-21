package top.smartpos.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartpos.blog.beans.domains.CountryDomain;
import top.smartpos.blog.mappers.CountryMapper;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;

    public List<CountryDomain> list() {
        return countryMapper.selectAll();
    }

    public CountryDomain findById() {
        return countryMapper.selectByPrimaryKey(10011);
    }
}
