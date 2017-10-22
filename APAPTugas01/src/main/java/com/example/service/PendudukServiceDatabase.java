package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PendudukMapper;
import com.example.model.Keluarga;
import com.example.model.Penduduk;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PendudukServiceDatabase implements PendudukService {

	@Autowired
	private PendudukMapper pendudukMapper;

	@Override
	public Penduduk selectPenduduk(String nik) {
		log.info("select penduduk with nik {}", nik);
		return pendudukMapper.selectPenduduk(nik);
	}

	@Override
	public void addPenduduk(Penduduk penduduk) {
		pendudukMapper.addPenduduk(penduduk);
	}

	@Override
	public Keluarga selectKeluarga(int idKeluarga) {
		return pendudukMapper.selectKeluarga(idKeluarga);
	}

	@Override
	public void updatePenduduk(Penduduk penduduk) {
		pendudukMapper.updatePenduduk(penduduk);
	}
}
