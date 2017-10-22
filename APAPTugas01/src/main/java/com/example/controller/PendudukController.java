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
import com.example.model.Penduduk;
import com.example.service.PendudukService;

@Controller
/**
 * 
 * @author Muthia
 * Kelas ini berfungsi sebagai controller untuk semua fitur yang berkaitan dengan penduduk
 */
public class PendudukController {
	@Autowired
    PendudukService pendudukDAO;
    
    //Menampilkan data penduduk
    @RequestMapping("/penduduk")
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
    
    //Menambahkan penduduk
    @RequestMapping("/penduduk/tambah")
    public String addPenduduk ()
    {
        return "add-penduduk";
    }
    
    @RequestMapping(value = "/penduduk/tambah/submit", method = RequestMethod.POST)
    public String addPendudukSubmit (Model model, @ModelAttribute Penduduk penduduk)
    {
    	Keluarga keluarga = pendudukDAO.selectKeluarga(penduduk.getIdKeluarga());
    	String kode = keluarga.getKelurahan().getKecamatan().getKodeKecamatan();
    	System.out.println(kode);
    	String newNik = kode.substring(0, 6);
    	
    	String date = penduduk.getTanggalLahir();
		String[] tanggalLengkap = date.split("-");
		String tahun = tanggalLengkap[0].substring(2, 4);
		String bulan = tanggalLengkap[1];
		String tanggal = tanggalLengkap[2];
		String tanggalLahirRemake = tanggal + bulan + tahun;

		if (penduduk.getJenisKelamin() == 1) {
			Integer perempuan = Integer.parseInt(tanggal) + 40;
			String tanggalLahirRemakePerempuan = perempuan + bulan + tahun;
			newNik += tanggalLahirRemakePerempuan;
		} else {
			newNik += tanggalLahirRemake;
		}
		
		newNik += 0001;
    	
		penduduk.setNik(newNik);
		model.addAttribute("newNik", newNik);	

        pendudukDAO.addPenduduk (penduduk);

        return "success-add-penduduk";
    }
    
    // Mengubah penduduk
    @RequestMapping("/penduduk/ubah/{nik}")
    public String update (Model model, @PathVariable(value = "nik") String nik)
    {
        Penduduk penduduk = pendudukDAO.selectPenduduk (nik);

        if (penduduk == null) {
        	model.addAttribute ("nik", nik);
            return "not-found-penduduk";
        } else {
        	model.addAttribute ("penduduk", penduduk);
            return "update-penduduk";
        }
    }
    
    @RequestMapping(value  =  "/penduduk/ubah/submit",  method = RequestMethod.POST)
    public String updateSubmit (Model model, @ModelAttribute Penduduk penduduk){
    	pendudukDAO.updatePenduduk (penduduk);
    	model.addAttribute("penduduk", penduduk);
        return "success-update-penduduk";
    }
}
