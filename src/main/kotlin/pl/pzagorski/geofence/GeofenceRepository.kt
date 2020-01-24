package pl.pzagorski.geofence

import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.stream.Stream

@Repository
interface GeofenceRepository : MongoRepository<Geofence, String> {
    @Query("{ 'polygon' : { \$geoIntersects: { \$geometry : ?0 } } }")
    fun findByPolygonIntersects(point: GeoJsonPoint): Stream<Geofence>
}
