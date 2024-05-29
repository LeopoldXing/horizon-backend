package com.leopoldhsing.horizon.configserver;

import com.leopoldhsing.horizon.configserver.config.PlaidConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class Test {

    @Autowired
    private PlaidConfiguration plaidConfiguration;

    @GetMapping
    public String test() {
        System.out.println(plaidConfiguration);
        return plaidConfiguration.toString();
    }
}
