package sakila

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LanguageServiceSpec extends Specification {

    LanguageService languageService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Language(...).save(flush: true, failOnError: true)
        //new Language(...).save(flush: true, failOnError: true)
        //Language language = new Language(...).save(flush: true, failOnError: true)
        //new Language(...).save(flush: true, failOnError: true)
        //new Language(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //language.id
    }

    void "test get"() {
        setupData()

        expect:
        languageService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Language> languageList = languageService.list(max: 2, offset: 2)

        then:
        languageList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        languageService.count() == 5
    }

    void "test delete"() {
        Long languageId = setupData()

        expect:
        languageService.count() == 5

        when:
        languageService.delete(languageId)
        sessionFactory.currentSession.flush()

        then:
        languageService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Language language = new Language()
        languageService.save(language)

        then:
        language.id != null
    }
}
