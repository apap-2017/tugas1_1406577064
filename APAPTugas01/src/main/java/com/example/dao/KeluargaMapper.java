package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
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
public interface KeluargaMapper {
	@Select("select * from keluarga where nomor_kk = #{nomorKk}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property = "nomorKk", column = "nomor_kk"), @Result(property = "alamat", column = "alamat"),
			@Result(property = "rt", column = "rt"), @Result(property = "rw", column = "rw"),
			@Result(property="idKelurahan", column="id_kelurahan"),
			@Result(property = "kelurahan", column = "id_kelurahan", javaType = Kelurahan.class, one = @One(select = "selectKelurahan")),
			@Result(property="isTidakBerlaku", column="is_tidak_berlaku"),
			@Result(property = "penduduks", column = "id", javaType = List.class, many = @Many(select = "selectPenduduks")) })
	Keluarga selectKeluarga(@Param("nomorKk") String nomorKk);

	@Select("Select *" + " from penduduk p join keluarga k on p.id_keluarga=k.id" + " where k.id=#{id}")
	@Results(value = {
			// @Result(property="id", column="id"),
			@Result(property = "nik", column = "nik"), @Result(property = "nama", column = "nama"),
			@Result(property = "tempatLahir", column = "tempat_lahir"),
			@Result(property = "tanggalLahir", column = "tanggal_lahir"),
			@Result(property = "jenisKelamin", column = "jenis_kelamin"),
			@Result(property = "isWni", column = "is_wni"),
			// @Result(property="idKeluarga", column="id_keluarga"),
			// @Result(property="keluarga", column="id_keluarga", javaType = Keluarga.class,
			// one = @One(select = "selectKeluarga")),
			@Result(property = "agama", column = "agama"), @Result(property = "pekerjaan", column = "pekerjaan"),
			@Result(property = "statusPerkawinan", column = "status_perkawinan"),
			@Result(property = "statusDalamKeluarga", column = "status_dalam_keluarga"),
			@Result(property = "golonganDarah", column = "golongan_darah"),
			// @Result(property="isWafat", column="is_wafat")
	})
	List<Penduduk> selectPenduduks(@Param("id_keluarga") String idKeluarga);

	@Select("select * from kelurahan where id = #{id_kelurahan}")
	@Results(value = {
			// @Result(property="id", column="id"),
			// @Result(property="kodeKelurahan", column="kode_kelurahan"),
			@Result(property = "namaKelurahan", column = "nama_kelurahan"),
			// @Result(property="kodePos", column="kode_pos"),
			@Result(property = "kecamatan", column = "id_kecamatan", javaType = Kecamatan.class, one = @One(select = "selectKecamatan")) })
	Kelurahan selectKelurahan(@Param("kode_kelurahan") String kodeKelurahan);

	@Select("select * from kecamatan where id = #{id_kecamatan}")
	@Results(value = {
			// @Result(property="id", column="id"),
			// @Result(property="kodeKecamatan", column="kode_kecamatan"),
			@Result(property = "namaKecamatan", column = "nama_kecamatan"),
			@Result(property = "kota", column = "id_kota", javaType = Kota.class, one = @One(select = "selectKota")) })
	Kecamatan selectKecamatan(@Param("kode_kecamatan") String kodeKecamatan);

	@Select("select * from kota where id = #{id_kota}")
	@Results(value = {
			// @Result(property="id", column="id"),
			// @Result(property="kodeKota", column="kode_kota"),
			@Result(property = "namaKota", column = "nama_kota") })
	Kota selectKota(@Param("kode_kota") String kodeKota);

	@Insert("INSERT INTO keluarga (nomor_kk, alamat, rt, rw, id_kelurahan, is_tidak_berlaku) "
			+ "VALUES (#{nomorKK}, #{alamat}, #{rt}, #{rw}, #{idKelurahan}, 0)")
	void addKeluarga(Keluarga keluarga);

	@Update("UPDATE keluarga " + "SET alamat=#{alamat}, RT=#{rt}, RW=#{rw}, id_kelurahan=#{idKelurahan} "
			+ "WHERE nomor_kk = #{nomorKk}")
	void updateKeluarga(Keluarga keluarga);
}