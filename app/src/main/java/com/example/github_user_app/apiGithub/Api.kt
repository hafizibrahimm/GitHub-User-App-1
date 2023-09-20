package com.example.github_user_app.apiGithub

import com.example.github_user_app.data.model.DetailUserResponse
import com.example.github_user_app.data.model.User
import com.example.github_user_app.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(@Query("q") query: String): Call<UserResponse>

    @GET("users")
    suspend fun getTopUsers(
        @Query("per_page") perPage: Int,
        @Query("since") sinceUserId: Int
    ): List<User>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ):Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ):Call<ArrayList<User>>
}