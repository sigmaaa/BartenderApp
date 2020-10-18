package com.bartender.controller;

import com.bartender.utils.SerialWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "pages/home";
    }

    @PostMapping("/")
    public String prepareDrink() throws IOException {
        SerialWriter.openPort("COM3");//need change name
        SerialWriter.sendStringToSerialPort("Test");
        return "pages/home";
    }
}
