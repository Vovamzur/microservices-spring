package com.example.getaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {

    @Autowired
    private ConfigClientAppConfiguration configClientAppConfiguration;

    // i can't serialize ConfigurationProperties with @ResponseBody annotation, so just use Map
    @GetMapping("/configs")
    @ResponseBody
    public Map<String, String> getConfig () {
        HashMap<String, String> map = new HashMap<>();
        map.put("property1", this.configClientAppConfiguration.getProperty1());
        map.put("property2", this.configClientAppConfiguration.getProperty2());
        return map;
    }
}
