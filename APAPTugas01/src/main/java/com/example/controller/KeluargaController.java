package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Keluarga;
import com.example.service.KeluargaService;

@Controller
/**
 * 
 * @author Muthia Kelas ini berfungsi sebagai controller untuk semua fitur yang
 *         berkaitan dengan keluarga
 */
public class KeluargaController {
	@Autowired
	KeluargaService keluargaDAO;

	// Menampilkan data penduduk dalam keluarga
	@RequestMapping("/keluarga")
	public String viewkeluarga(Model model, @RequestParam(value = "nkk", required = false) String nomorKk) {
		Keluarga keluarga = keluargaDAO.selectKeluarga(nomorKk);

		if (keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			return "view-keluarga";
		} else {
			model.addAttribute("nomorKk", nomorKk);
			return "not-found-keluarga";
		}
	}

	// Menambahkan keluarga
	@RequestMapping("/keluarga/tambah")
	public String addKeluarga() {
		return "add-keluarga";
	}

	@RequestMapping(value = "/keluarga/tambah/submit", method = RequestMethod.POST)
	public String addPendudukSubmit(Model model, @ModelAttribute Keluarga keluarga) {

		// model.addAttribute("newNkk", newNkk);

		keluargaDAO.addKeluarga(keluarga);

		return "success-add-keluarga";
	}

	// Mengubah keluarga
	@RequestMapping("/keluarga/ubah/{nomorKk}")
	public String update(Model model, @PathVariable(value = "nomorKk") String nomorKk) {
		Keluarga keluarga = keluargaDAO.selectKeluarga(nomorKk);

		if (keluarga == null) {
			model.addAttribute("nomorKk", nomorKk);
			return "not-found-keluarga";
		} else {
			model.addAttribute("keluarga", keluarga);
			return "update-keluarga";
		}
	}

	@RequestMapping(value = "/keluarga/ubah/submit", method = RequestMethod.POST)
	public String updateSubmit(Model model, @ModelAttribute Keluarga keluarga) {
		keluargaDAO.updateKeluarga(keluarga);
		model.addAttribute("keluarga", keluarga);
		return "success-update-keluarga";
	}
}
