package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Keluarga;
import com.example.service.KeluargaService;

@Controller
public class KeluargaController {
	@Autowired
    KeluargaService keluargaDAO;
    
    //Menampilkan data penduduk dalam keluarga
    @RequestMapping(value = "/keluarga", method = RequestMethod.POST)
    public String viewkeluarga (Model model, @RequestParam(value = "nkk", required = false) String nomorKk)
    {
    	Keluarga keluarga = keluargaDAO.selectKeluarga(nomorKk);
    	
        if (keluarga != null) {
            model.addAttribute ("keluarga", keluarga);
            return "view-keluarga";
        } else {
            model.addAttribute ("nomorKk", nomorKk);
            return "not-found-keluarga";
        }
    }
}
