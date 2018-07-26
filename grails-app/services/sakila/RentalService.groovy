package sakila

import grails.gorm.services.Service

@Service(Rental)
interface RentalService {

    Rental get(Serializable id)

    List<Rental> list(Map args)

    Long count()

    void delete(Serializable id)

    Rental save(Rental rental)

}