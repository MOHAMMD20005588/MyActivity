package com.example.pagination.Api


import com.google.gson.annotations.SerializedName

data class movie_responses(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("metadata")
    val metadata: Metadata?
) {
    data class Data(
        @SerializedName("genres")
        val genres: List<String?>?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("images")
        val images: List<String?>?,
        @SerializedName("poster")
        val poster: String?,
        @SerializedName("title")
        val title: String?
    )

    data class Metadata(
        @SerializedName("current_page")
        val currentPage: Int?,
        @SerializedName("page_count")
        val pageCount: Int?,
        @SerializedName("per_page")
        val perPage: Int?,
        @SerializedName("total_count")
        val totalCount: Int?
    )
}