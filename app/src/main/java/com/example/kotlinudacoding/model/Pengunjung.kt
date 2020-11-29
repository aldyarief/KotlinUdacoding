package com.example.kotlinudacoding.model

import com.google.gson.annotations.SerializedName

data class Pengunjung(

	@field:SerializedName("hasildata")
	val hasildata: List<HasildataItem?>? = null
)

data class HasildataItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("telp")
	val telp: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("idpengunjung")
	val idpengunjung: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
)
