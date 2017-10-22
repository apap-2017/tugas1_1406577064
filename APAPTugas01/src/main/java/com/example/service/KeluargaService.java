package com.example.service;

import com.example.model.Keluarga;

public interface KeluargaService {
	Keluarga selectKeluarga (String nomorKk);

	void addKeluarga(Keluarga keluarga);

	void updateKeluarga(Keluarga keluarga);
}
