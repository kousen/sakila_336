package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RentalServiceSpec extends Specification {

    RentalService rentalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rental(...).save(flush: true, failOnError: true)
        //new Rental(...).save(flush: true, failOnError: true)
        //Rental rental = new Rental(...).save(flush: true, failOnError: true)
        //new Rental(...).save(flush: true, failOnError: true)
        //new Rental(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rental.id
    }

    void "test get"() {
        setupData()

        expect:
        rentalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rental> rentalList = rentalService.list(max: 2, offset: 2)

        then:
        rentalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rentalService.count() == 5
    }

    void "test delete"() {
        Long rentalId = setupData()

        expect:
        rentalService.count() == 5

        when:
        rentalService.delete(rentalId)
        sessionFactory.currentSession.flush()

        then:
        rentalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rental rental = new Rental()
        rentalService.save(rental)

        then:
        rental.id != null
    }
}
