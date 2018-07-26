package sakila

import grails.gorm.services.Service

@Service(Store)
interface StoreService {

    Store get(Serializable id)

    List<Store> list(Map args)

    Long count()

    void delete(Serializable id)

    Store save(Store store)

}