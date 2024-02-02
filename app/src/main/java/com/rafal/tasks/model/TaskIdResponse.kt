package com.rafal.tasks.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TaskIdResponse(val name: String) {

}
