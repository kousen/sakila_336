package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StoreServiceSpec extends Specification {

    StoreService storeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Store(...).save(flush: true, failOnError: true)
        //new Store(...).save(flush: true, failOnError: true)
        //Store store = new Store(...).save(flush: true, failOnError: true)
        //new Store(...).save(flush: true, failOnError: true)
        //new Store(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //store.id
    }

    void "test get"() {
        setupData()

        expect:
        storeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Store> storeList = storeService.list(max: 2, offset: 2)

        then:
        storeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        storeService.count() == 5
    }

    void "test delete"() {
        Long storeId = setupData()

        expect:
        storeService.count() == 5

        when:
        storeService.delete(storeId)
        sessionFactory.currentSession.flush()

        then:
        storeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Store store = new Store()
        storeService.save(store)

        then:
        store.id != null
    }
}
