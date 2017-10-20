package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Penduduk;
import com.example.service.PendudukService;

@Controller
public class PendudukController {
	@Autowired
    PendudukService pendudukDAO;
	
	@RequestMapping("/")
    public String index ()
    {
        return "index";
    }
    
    //Menampilkan data penduduk.
    @RequestMapping(value = "/penduduk", method = RequestMethod.POST)
    public String viewPenduduk (Model model, @RequestParam(value = "nik", required = false) String nik)
    {
    	Penduduk penduduk = pendudukDAO.selectPenduduk(nik);
    	
        if (penduduk != null) {
            model.addAttribute ("penduduk", penduduk);
            return "view-penduduk";
        } else {
            model.addAttribute ("nik", nik);
            return "not-found-penduduk";
        }
    }
}
