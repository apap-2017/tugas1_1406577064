package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kecamatan {
	private int id;
	private int idKota;
	private String kodeKecamatan;
	private String namaKecamatan;
	private Kota kota;
}
