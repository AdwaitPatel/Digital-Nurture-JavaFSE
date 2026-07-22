package com.cognizant.SpringBoot15Jul.controller0;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // for building RestAPIs
@RequestMapping(value = "/api")
public class AppController {

    @RequestMapping(value = {"/home", "/dashboard"}, method = RequestMethod.GET)
     public String home() {
         return "<h1>Home Page</h1>";
     }


    @RequestMapping(value = "/student/{sid}", method = RequestMethod.GET)
     public Map getAll(@PathVariable("sid") int id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("student", id);
         return map;
     }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
     public String calculator(@PathParam("a") int a, @PathParam("b") int b) {
         return "<h1>a = " + a + " b = " + b + "</h1>";
     }


//     @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
     public String m1() {
        return "GET";
     }

//     @RequestMapping(value = "/", method = RequestMethod.POST)
    @PostMapping("/")
     public String m2() {
        return "POST";
     }

//     @RequestMapping(value = "/", method = RequestMethod.PUT)
     @PutMapping("/")
     public String m3() {
        return "PUT";
     }

//     @RequestMapping(value = "/", method = RequestMethod.DELETE)
    @DeleteMapping("/")
     public String m4() {
        return "DELETE";
     }






}
