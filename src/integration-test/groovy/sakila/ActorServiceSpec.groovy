package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ActorServiceSpec extends Specification {

    ActorService actorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Actor(...).save(flush: true, failOnError: true)
        //new Actor(...).save(flush: true, failOnError: true)
        //Actor actor = new Actor(...).save(flush: true, failOnError: true)
        //new Actor(...).save(flush: true, failOnError: true)
        //new Actor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //actor.id
    }

    void "test get"() {
        setupData()

        expect:
        actorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Actor> actorList = actorService.list(max: 2, offset: 2)

        then:
        actorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        actorService.count() == 5
    }

    void "test delete"() {
        Long actorId = setupData()

        expect:
        actorService.count() == 5

        when:
        actorService.delete(actorId)
        sessionFactory.currentSession.flush()

        then:
        actorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Actor actor = new Actor()
        actorService.save(actor)

        then:
        actor.id != null
    }
}
