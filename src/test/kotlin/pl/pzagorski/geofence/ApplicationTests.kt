package pl.pzagorski.geofence

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTests {

	@Test
	fun contextLoads() {
		Assert.assertTrue(LocalDateTime.parse("2019-06-05T10:15:30") in LocalDateTime.parse("2019-06-01T10:15:30") .. LocalDateTime.parse("2019-06-10T10:15:30"))
	}

}
