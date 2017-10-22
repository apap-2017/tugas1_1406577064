package com.example.service;

import com.example.model.Keluarga;
import com.example.model.Penduduk;

public interface PendudukService {
	Penduduk selectPenduduk (String nik);
	
	void addPenduduk(Penduduk penduduk);
	
	//Penduduk kodeKec(int idKeluarga);

	Keluarga selectKeluarga(int idKeluarga);
}
