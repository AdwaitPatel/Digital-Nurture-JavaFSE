package com.cognizant.country_web.service;

import com.cognizant.country_web.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }
}
