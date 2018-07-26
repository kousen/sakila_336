package sakila

import grails.gorm.services.Service

@Service(Language)
interface LanguageService {

    Language get(Serializable id)

    List<Language> list(Map args)

    Long count()

    void delete(Serializable id)

    Language save(Language language)

}