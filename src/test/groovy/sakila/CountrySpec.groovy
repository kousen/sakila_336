package sakila

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class CountrySpec extends Specification implements DomainUnitTest<Country> {
    @Shared int id

    void "test basic persistence mocking"() {
        setup:
        new Country(name: 'Westeros').save(failOnError: true)
        new Country(name: 'Narnia').save(failOnError: true)

        expect:
        Country.count() == 2
    }

    void "test domain instance"() {
        setup:
        id = System.identityHashCode(domain)

        expect:
        domain != null
        domain.hashCode() == id

        when:
        domain.name = 'Westeros'

        then:
        domain.name == 'Westeros'
    }

    void "test we get a new domain"() {
        expect:
        domain != null
        domain.name == null
        System.identityHashCode(domain) != id
    }
}
