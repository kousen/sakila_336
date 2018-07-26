package sakila

import grails.gorm.services.Service

@Service(ActorInfo)
interface ActorInfoService {

    ActorInfo get(Serializable id)

    List<ActorInfo> list(Map args)

    Long count()

    void delete(Serializable id)

    ActorInfo save(ActorInfo actorInfo)

}