package sakila

import grails.gorm.services.Service

@Service(SalesByFilmCategory)
interface SalesByFilmCategoryService {

    SalesByFilmCategory get(Serializable id)

    List<SalesByFilmCategory> list(Map args)

    Long count()

    void delete(Serializable id)

    SalesByFilmCategory save(SalesByFilmCategory salesByFilmCategory)

}