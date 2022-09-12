package com.example.lab4;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}")
    public String myPlus(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        double total = n1+n2;
        String totalString = String.valueOf(total);
        return totalString;
    }

    @RequestMapping(value = "/minus/{n1}/{n2}")
    public String myMinus(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        double total = n1-n2;
        String totalString = String.valueOf(total);
        return totalString;
    }

    @RequestMapping(value = "/divide/{n1}/{n2}")
    public String myDivide(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        double total = n1/n2;
        String totalString = String.valueOf(total);
        return totalString;
    }

    @RequestMapping(value = "/multi/{n1}/{n2}")
    public String myMulti(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        double total = n1*n2;
        String totalString = String.valueOf(total);
        return totalString;
    }

    @RequestMapping(value = "/mod/{n1}/{n2}")
    public String myMod(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        double total = n1%n2;
        String totalString = String.valueOf(total);
        return totalString;
    }


    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestBody MultiValueMap<String, String> n) {
        Map<String, String> d = n.toSingleValueMap();
        double maxNum = Math.max(Double.parseDouble(d.get("n1")), Double.parseDouble(d.get("n2")));
        return maxNum+"";
    }
}