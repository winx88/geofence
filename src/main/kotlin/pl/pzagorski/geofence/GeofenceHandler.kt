package pl.pzagorski.geofence

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/geofence")
class GeofenceHandler @Autowired constructor(val geofenceRepository: GeofenceRepository, val geofenceService: GeofenceService) {

    @GetMapping
    fun getGeofence(): List<Geofence> {
        return geofenceService.getGeofence()
    }

    @GetMapping(value = "/save")
    fun saveGeofence() {
        val points = listOf(GeoJsonPoint(16.845234,52.459038), GeoJsonPoint( 17.027473, 52.462962),
                GeoJsonPoint( 16.979882, 52.362174), GeoJsonPoint(16.846565, 52.365430), GeoJsonPoint(16.845234,52.459038))
        geofenceRepository.save(Geofence(name = "Poznan", polygon = GeoJsonPolygon(points)))
    }


    @GetMapping(value = "/check")
    fun checkGeofence(): String {
        return if(geofenceService.findGeofence(GeoJsonPoint(16.922785, 52.410637)).isEmpty()) "OUT" else "IN"
    }
}