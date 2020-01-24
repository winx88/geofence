package pl.pzagorski.geofence

import org.springframework.data.mongodb.core.geo.GeoJsonPoint

interface GeofenceService {

    fun getGeofence(): List<Geofence>
    fun findGeofence(point: GeoJsonPoint): List<Geofence>
}