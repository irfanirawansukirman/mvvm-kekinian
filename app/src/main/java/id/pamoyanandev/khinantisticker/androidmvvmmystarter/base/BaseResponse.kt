package id.pamoyanandev.khinantisticker.androidmvvmmystarter.base

data class BaseResponse<out T>(val errorCode: Int, val errorMessage: String, val data: T)