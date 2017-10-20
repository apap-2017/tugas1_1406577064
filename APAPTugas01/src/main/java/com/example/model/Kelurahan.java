package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kelurahan {
	private int id;
	private int idKecamatan;
	private String kodeKelurahan;
	private String namaKelurahan;
	private String kodePos;
	private Kecamatan kecamatan;
}
