package com.example.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Penduduk {
	private int id;
	private String nik;
	private String nama;
	private String tempatLahir;
	private String tanggalLahir;
	private int jenisKelamin; //(0 = Pria, 1 = Wanita)
	private Integer isWni; //penduduk WNI atau WNA
	private int idKeluarga;
	private String agama;
	private String pekerjaan;
	private String statusPerkawinan;
	private String statusDalamKeluarga; //(contoh: ayah, ibu, anak)
	private String golonganDarah;
	private Integer isWafat;
	private Keluarga keluarga;
	private String kodeKecamatan;
}
