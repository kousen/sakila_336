package sakila

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SalesByFilmCategoryController {

    SalesByFilmCategoryService salesByFilmCategoryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond salesByFilmCategoryService.list(params), model:[salesByFilmCategoryCount: salesByFilmCategoryService.count()]
    }

    def show(Long id) {
        respond salesByFilmCategoryService.get(id)
    }

    def create() {
        respond new SalesByFilmCategory(params)
    }

    def save(SalesByFilmCategory salesByFilmCategory) {
        if (salesByFilmCategory == null) {
            notFound()
            return
        }

        try {
            salesByFilmCategoryService.save(salesByFilmCategory)
        } catch (ValidationException e) {
            respond salesByFilmCategory.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'salesByFilmCategory.label', default: 'SalesByFilmCategory'), salesByFilmCategory.id])
                redirect salesByFilmCategory
            }
            '*' { respond salesByFilmCategory, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond salesByFilmCategoryService.get(id)
    }

    def update(SalesByFilmCategory salesByFilmCategory) {
        if (salesByFilmCategory == null) {
            notFound()
            return
        }

        try {
            salesByFilmCategoryService.save(salesByFilmCategory)
        } catch (ValidationException e) {
            respond salesByFilmCategory.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'salesByFilmCategory.label', default: 'SalesByFilmCategory'), salesByFilmCategory.id])
                redirect salesByFilmCategory
            }
            '*'{ respond salesByFilmCategory, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        salesByFilmCategoryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'salesByFilmCategory.label', default: 'SalesByFilmCategory'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'salesByFilmCategory.label', default: 'SalesByFilmCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
