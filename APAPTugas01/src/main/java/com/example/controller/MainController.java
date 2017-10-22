package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 * 
 * @author Muthia
 * Kelas ini berfungsi sebagai controller untuk semua fitur umum
 */
public class MainController {
	
	@RequestMapping("/")
    public String index ()
    {
        return "index";
    }
}
