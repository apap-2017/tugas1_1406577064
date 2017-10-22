package com.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.Kecamatan;
import com.example.model.Keluarga;
import com.example.model.Kelurahan;
import com.example.model.Kota;
import com.example.model.Penduduk;

@Mapper
public interface PendudukMapper {
	@Select("select * from penduduk where nik = #{nik}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property = "nik", column = "nik"), @Result(property = "nama", column = "nama"),
			@Result(property = "tempatLahir", column = "tempat_lahir"),
			@Result(property = "tanggalLahir", column = "tanggal_lahir"),
			@Result(property="jenisKelamin", column="jenis_kelamin"),
			@Result(property = "isWni", column = "is_wni"),
			@Result(property="idKeluarga", column="id_keluarga"),
			@Result(property = "keluarga", column = "id_keluarga", javaType = Keluarga.class, one = @One(select = "selectKeluarga")),
			@Result(property = "agama", column = "agama"), @Result(property = "pekerjaan", column = "pekerjaan"),
			@Result(property = "statusPerkawinan", column = "status_perkawinan"),
			@Result(property="statusDalamKeluarga", column="status_dalam_keluarga"),
			@Result(property = "golonganDarah", column = "golongan_darah"),
			@Result(property = "isWafat", column = "is_wafat") })
	Penduduk selectPenduduk(@Param("nik") String nik);

	@Select("select * from keluarga where id = #{id_keluarga}")
	@Results(value = {
			// @Result(property="id", column="id"),
			// @Result(property="nomorKk", column="nomor_kk"),
			@Result(property = "alamat", column = "alamat"), @Result(property = "rt", column = "rt"),
			@Result(property = "rw", column = "rw"),
			@Result(property = "kelurahan", column = "id_kelurahan", javaType = Kelurahan.class, one = @One(select = "selectKelurahan")),
			// @Result(property="isTidakBerlaku", column="is_tidak_berlaku"),
	})
	Keluarga selectKeluarga(@Param("id_keluarga") int idKeluarga);

	@Select("select * from kelurahan where id = #{id_kelurahan}")
	@Results(value = {
			// @Result(property="id", column="id"),
			// @Result(property="kodeKelurahan", column="kode_kelurahan"),
			@Result(property = "namaKelurahan", column = "nama_kelurahan"),
			// @Result(property="kodePos", column="kode_pos"),
			@Result(property = "kecamatan", column = "id_kecamatan", javaType = Kecamatan.class, one = @One(select = "selectKecamatan")) })
	Kelurahan selectKelurahan(@Param("id") int id);

	@Select("select * from kecamatan where id = #{id_kecamatan}")
	@Results(value = {
			// @Result(property="id", column="id"),
			// @Result(property="kodeKecamatan", column="kode_kecamatan"),
			@Result(property = "namaKecamatan", column = "nama_kecamatan"),
			@Result(property = "kota", column = "id_kota", javaType = Kota.class, one = @One(select = "selectKota")) })
	Kecamatan selectKecamatan(@Param("id") int id);

	@Select("select * from kota where id = #{id_kota}")
	@Results(value = {
			// @Result(property="id", column="id"),
			// @Result(property="kodeKota", column="kode_kota"),
			@Result(property = "namaKota", column = "nama_kota") })
	Kota selectKota(@Param("id") int id);

	@Insert("INSERT INTO penduduk (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat) "
			+ "VALUES (#{nik}, #{nama}, #{tempatLahir}, #{tanggalLahir}, #{jenisKelamin}, #{isWni}, #{idKeluarga}, #{agama}, #{pekerjaan}, #{statusPerkawinan}, #{statusDalamKeluarga}, #{golonganDarah}, #{isWafat})")
	void addPenduduk(Penduduk penduduk);

	@Update("UPDATE penduduk " + "SET nama=#{nama}, tempat_lahir=#{tempatLahir}, tanggal_lahir=#{tanggalLahir}, "
			+ "golongan_darah=#{golonganDarah}, agama=#{agama}, jenis_kelamin=#{jenisKelamin}, pekerjaan=#{pekerjaan}, "
			+ "is_wni=#{isWni}, status_dalam_keluarga=#{statusDalamKeluarga}, status_perkawinan=#{statusPerkawinan}, id_keluarga=#{idKeluarga} "
			+ "WHERE nik = #{nik}")
	void updatePenduduk(Penduduk penduduk);
}