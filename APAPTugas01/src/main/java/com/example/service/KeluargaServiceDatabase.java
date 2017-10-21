package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KeluargaMapper;
import com.example.model.Keluarga;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KeluargaServiceDatabase implements KeluargaService {

	@Autowired
	private KeluargaMapper keluargaMapper;

	@Override
	public Keluarga selectKeluarga(String nomorKk) {
		log.info("select penduduk with nkk {}", nomorKk);
		return keluargaMapper.selectKeluarga(nomorKk);
	}
}
