package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CityServiceSpec extends Specification {

    CityService cityService
    CountryService countryService
    SessionFactory sessionFactory

    void "there should be 600 cities"() {
        expect:
        cityService.count() == 600
    }

    void "test save and delete"() {
        given:
        Country country = new Country(name: 'Westeros')
        City city = new City(name: "King's Landing", country: country)

        when:
        countryService.save(country)
        cityService.save(city)

        then:
        city.id

        when:
        cityService.delete(city.id)
        countryService.delete(country.id)
        sessionFactory.currentSession.flush()

        then:
        cityService.count() == 600
    }
}
