package sakila

import grails.gorm.services.Service

@Service(Actor)
interface ActorService {

    Actor get(Serializable id)

    List<Actor> list(Map args)

    Long count()

    void delete(Serializable id)

    Actor save(Actor actor)

}