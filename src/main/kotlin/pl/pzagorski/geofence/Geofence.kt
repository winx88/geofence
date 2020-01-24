package pl.pzagorski.geofence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType.GEO_2DSPHERE
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed

class Geofence(@Id var id: String? = null, var name: String?, @GeoSpatialIndexed(type = GEO_2DSPHERE) var polygon: GeoJsonPolygon)