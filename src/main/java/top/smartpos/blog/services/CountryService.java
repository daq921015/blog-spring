package top.smartpos.blog.services;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import top.smartpos.blog.beans.domains.CountryDomain;
import top.smartpos.blog.beans.models.CountryModel;
import top.smartpos.blog.mappers.CountryMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {
    private final CountryMapper countryMapper;

    @Autowired
    public CountryService(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    public List<CountryDomain> list() {
        return countryMapper.selectAll();
    }

    public int findById() {
//        Example
        Example example = new Example(CountryDomain.class, true, true);
        example.setCountProperty("id");
        Example.Criteria criteria = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();
        criteria.andEqualTo("id", 1);
        criteria.andEqualTo("countryCode", "001");
        criteria.orEqualTo("countryName", "北京");
        criteria2.orEqualTo("addr", 1);
        example.or(criteria2);
        return countryMapper.selectCountByExample(example);
    }

    public Object save(CountryModel countryModel) {
        CountryDomain countryDomain = new CountryDomain();
        countryDomain.setCountryCode(countryModel.getCountryCode());
        countryDomain.setCountryName(countryModel.getCountryName());
        countryDomain.setId(countryModel.getId());
        if (!NumberUtils.isParsable(String.valueOf(countryModel.getId()))) {
            return countryMapper.insert(countryDomain);
        }
        return countryMapper.updateByPrimaryKey(countryDomain);
    }

    @Transactional
    public Object insert() {
        CountryDomain country1 = new CountryDomain();
        country1.setCountryName("北京");
        country1.setCountryCode("001");
        CountryDomain country2 = new CountryDomain();
        country2.setCountryName("上海");
        country2.setCountryCode("002");
        ArrayList<CountryDomain> list = new ArrayList<CountryDomain>() {{
            add(country1);
            add(country2);
        }};
        for (CountryDomain countryDomain : list) {
            int aa = countryMapper.insert(countryDomain);
            System.out.println(aa);
        }
        return "批量插入完成";
    }
}
