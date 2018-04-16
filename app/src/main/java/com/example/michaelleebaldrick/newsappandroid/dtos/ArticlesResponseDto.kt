package com.example.michaelleebaldrick.newsappandroid.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class ArticlesResponseDto(
        @JsonProperty("status") val status: String,
        @JsonProperty("source") val source: String,
        @JsonProperty("sortBy") val sortBy: String,
        @JsonProperty("articles") val articles: List<Articles>
)

data class Articles (
        @JsonProperty("author") val author: String? = "",
        @JsonProperty("title") val title: String,
        @JsonProperty("description") val description: String,
        @JsonProperty("url") val url: String,
        @JsonProperty("urlToImage") val urlToImage: String,
        @JsonProperty("publishedAt") val publishedAt: String? = ""

)