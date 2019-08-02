package id.pamoyanandev.khinantisticker.androidmvvmmystarter.util.ext

import id.pamoyanandev.khinantisticker.androidmvvmmystarter.base.BaseResponse

//suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {
//
//    val result: BaseResults<T> = safeApiResult(call, errorMessage)
//    var data: T? = null
//
//    when (result) {
//        is BaseResults.Success ->
//            data = result.data
//
//        is BaseResults.Error -> {
//            Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
//        }
//    }
//
//    return data
//}
//
//private suspend fun <T : Any> safeApiResult(
//    call: suspend () -> Response<T>,
//    errorMessage: String
//): BaseResults<T> {
//    val response = call.invoke()
//    if (response.isSuccessful) return BaseResults.Success(response.body()!!)
//
//    return BaseResults.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
//}

suspend fun <T : Any> apiCall(call: suspend () -> BaseResponse<T>): BaseResponse<T> {
    return call.invoke()
}

