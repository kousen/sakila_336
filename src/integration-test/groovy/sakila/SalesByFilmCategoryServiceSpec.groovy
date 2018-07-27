package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SalesByFilmCategoryServiceSpec extends Specification {

    SalesByFilmCategoryService salesByFilmCategoryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SalesByFilmCategory(...).save(flush: true, failOnError: true)
        //new SalesByFilmCategory(...).save(flush: true, failOnError: true)
        //SalesByFilmCategory salesByFilmCategory = new SalesByFilmCategory(...).save(flush: true, failOnError: true)
        //new SalesByFilmCategory(...).save(flush: true, failOnError: true)
        //new SalesByFilmCategory(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //salesByFilmCategory.id
    }

    void "test get"() {
        setupData()

        expect:
        salesByFilmCategoryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SalesByFilmCategory> salesByFilmCategoryList = salesByFilmCategoryService.list(max: 2, offset: 2)

        then:
        salesByFilmCategoryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        salesByFilmCategoryService.count() == 5
    }

    void "test delete"() {
        Long salesByFilmCategoryId = setupData()

        expect:
        salesByFilmCategoryService.count() == 5

        when:
        salesByFilmCategoryService.delete(salesByFilmCategoryId)
        sessionFactory.currentSession.flush()

        then:
        salesByFilmCategoryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SalesByFilmCategory salesByFilmCategory = new SalesByFilmCategory()
        salesByFilmCategoryService.save(salesByFilmCategory)

        then:
        salesByFilmCategory.id != null
    }
}
