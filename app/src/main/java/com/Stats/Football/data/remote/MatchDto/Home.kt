package com.Stats.Football.data.remote.MatchDto

import com.Stats.Football.domain.model.HomeModel

data class Home(
    val cc: String,
    val id: String,
    val image_id: String,
    val name: String
)

fun Home.toHomeModel(): HomeModel {
    return HomeModel(
        cc = cc,
        id = id,
        imageId = image_id,
        name = name
    );
}