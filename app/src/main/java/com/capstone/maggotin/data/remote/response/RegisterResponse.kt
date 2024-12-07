package com.capstone.maggotin.data.remote.response

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
	val name: String,
	val email: String,
	val password: String,
	val confirmPassword: String
)

data class RegisterResponse(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)
