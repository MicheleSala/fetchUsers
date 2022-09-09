package com.fetchusersapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@Component
public class FetchUserService {

    public Map fetchUser(String gender) {
        RestTemplate restTemplate = new RestTemplate(); 
        String host = "https://gorest.co.in"; 
        String service = "/public/v2/users";
        if (gender != null) { 
            service += "?gender=" + gender; 
        }
        List<Map> res = restTemplate.getForObject(host + service, List.class); 
        Map<String, Object> response = new HashMap<>(); 
        response.put("data", res); 
        return response; 

    }
    
}
