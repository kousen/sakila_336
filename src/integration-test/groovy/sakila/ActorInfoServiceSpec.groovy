package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ActorInfoServiceSpec extends Specification {

    ActorInfoService actorInfoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ActorInfo(...).save(flush: true, failOnError: true)
        //new ActorInfo(...).save(flush: true, failOnError: true)
        //ActorInfo actorInfo = new ActorInfo(...).save(flush: true, failOnError: true)
        //new ActorInfo(...).save(flush: true, failOnError: true)
        //new ActorInfo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //actorInfo.id
    }

    void "test get"() {
        setupData()

        expect:
        actorInfoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ActorInfo> actorInfoList = actorInfoService.list(max: 2, offset: 2)

        then:
        actorInfoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        actorInfoService.count() == 5
    }

    void "test delete"() {
        Long actorInfoId = setupData()

        expect:
        actorInfoService.count() == 5

        when:
        actorInfoService.delete(actorInfoId)
        sessionFactory.currentSession.flush()

        then:
        actorInfoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ActorInfo actorInfo = new ActorInfo()
        actorInfoService.save(actorInfo)

        then:
        actorInfo.id != null
    }
}
