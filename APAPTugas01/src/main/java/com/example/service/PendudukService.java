package com.example.service;

import com.example.model.Keluarga;
import com.example.model.Penduduk;

public interface PendudukService {
	Penduduk selectPenduduk (String nik);
	
	void addPenduduk(Penduduk penduduk);

	Keluarga selectKeluarga(int idKeluarga);

	void updatePenduduk(Penduduk penduduk);

	void ubahKematianPenduduk(String nik);
}
