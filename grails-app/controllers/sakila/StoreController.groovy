package sakila

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StoreController {

    StoreService storeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond storeService.list(params), model:[storeCount: storeService.count()]
    }

    def show(Long id) {
        respond storeService.get(id)
    }

    def create() {
        respond new Store(params)
    }

    def save(Store store) {
        if (store == null) {
            notFound()
            return
        }

        try {
            storeService.save(store)
        } catch (ValidationException e) {
            respond store.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'store.label', default: 'Store'), store.id])
                redirect store
            }
            '*' { respond store, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond storeService.get(id)
    }

    def update(Store store) {
        if (store == null) {
            notFound()
            return
        }

        try {
            storeService.save(store)
        } catch (ValidationException e) {
            respond store.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'store.label', default: 'Store'), store.id])
                redirect store
            }
            '*'{ respond store, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        storeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'store.label', default: 'Store'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'store.label', default: 'Store'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
