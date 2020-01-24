package pl.pzagorski.geofence

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
internal class GeofenceServiceImpl : GeofenceService {

    @Autowired
    lateinit var geofenceRepository: GeofenceRepository

    override fun getGeofence(): MutableList<Geofence> = geofenceRepository.findAll()

    override fun findGeofence(point: GeoJsonPoint): List<Geofence> {
        //db.geofence.createIndex({polygon:"2dsphere"})
        return geofenceRepository.findByPolygonIntersects(point).toList()
    }
}