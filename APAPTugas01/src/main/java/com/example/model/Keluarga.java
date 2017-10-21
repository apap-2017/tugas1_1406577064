package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Keluarga {
	private int id;
	private String nomorKk;
	private String alamat;
	private String rt;
	private String rw;
	private int idKelurahan;
	private Integer isTidakBerlaku;
	private Kelurahan kelurahan;
	private List<Penduduk> penduduks;
}
