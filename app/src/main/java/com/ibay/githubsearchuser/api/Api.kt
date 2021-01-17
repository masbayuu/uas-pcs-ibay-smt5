package com.ibay.githubsearchuser.api

import com.ibay.githubsearchuser.data.model.DetailUserResponse
import com.ibay.githubsearchuser.data.model.User
import com.ibay.githubsearchuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/search/users")
    @Headers("Authorization: token 155b09f6b032a5ddddfc09dc2e2e8e1a01617e2b")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("/users/{username}")
    @Headers("Authorization: token 155b09f6b032a5ddddfc09dc2e2e8e1a01617e2b")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("/users/{username}/followers")
    @Headers("Authorization: token 155b09f6b032a5ddddfc09dc2e2e8e1a01617e2b")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("/users/{username}/following")
    @Headers("Authorization: token 155b09f6b032a5ddddfc09dc2e2e8e1a01617e2b")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}