package id.pamoyanandev.khinantisticker.androidmvvmmystarter.base

sealed class BaseResults<out T: Any> {
    data class Success<out T : Any>(val data: T) : BaseResults<T>()
    data class Error(val exception: Exception) : BaseResults<Nothing>()
}