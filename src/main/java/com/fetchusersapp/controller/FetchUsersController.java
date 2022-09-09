package com.fetchusersapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fetchusersapp.service.FetchUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/my-api")
@CrossOrigin(origins = "*")
public class FetchUsersController {

    @Autowired
    FetchUserService fetchUserService; 

    Logger logger = LoggerFactory.getLogger(FetchUsersController.class); 

    @RequestMapping(
        value = "/users",
        method = RequestMethod.GET, 
        produces = "application/json"
    )
    @ResponseBody
    public Map<String, Object> fetchUsers(@RequestParam(required = false) String gender) {
        Map<String, Object> response = fetchUserService.fetchUser(gender); 
        return response; 
    }

    
}
