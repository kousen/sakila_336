package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class StaffServiceSpec extends Specification {

    StaffService staffService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Staff(...).save(flush: true, failOnError: true)
        //new Staff(...).save(flush: true, failOnError: true)
        //Staff staff = new Staff(...).save(flush: true, failOnError: true)
        //new Staff(...).save(flush: true, failOnError: true)
        //new Staff(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //staff.id
    }

    void "test get"() {
        setupData()

        expect:
        staffService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Staff> staffList = staffService.list(max: 2, offset: 2)

        then:
        staffList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        staffService.count() == 5
    }

    void "test delete"() {
        Long staffId = setupData()

        expect:
        staffService.count() == 5

        when:
        staffService.delete(staffId)
        sessionFactory.currentSession.flush()

        then:
        staffService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Staff staff = new Staff()
        staffService.save(staff)

        then:
        staff.id != null
    }
}
