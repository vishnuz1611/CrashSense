package com.whiskey.alertsys

data class Accident(
    var date: String ?= null,
    var latitude: Double ?= null,
    var longitude: Double ?= null,
    var place: String ?= null,
    var time: String ?= null
)

