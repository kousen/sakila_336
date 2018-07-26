package sakila

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InventoryController {

    InventoryService inventoryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond inventoryService.list(params), model:[inventoryCount: inventoryService.count()]
    }

    def show(Long id) {
        respond inventoryService.get(id)
    }

    def create() {
        respond new Inventory(params)
    }

    def save(Inventory inventory) {
        if (inventory == null) {
            notFound()
            return
        }

        try {
            inventoryService.save(inventory)
        } catch (ValidationException e) {
            respond inventory.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'inventory.label', default: 'Inventory'), inventory.id])
                redirect inventory
            }
            '*' { respond inventory, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond inventoryService.get(id)
    }

    def update(Inventory inventory) {
        if (inventory == null) {
            notFound()
            return
        }

        try {
            inventoryService.save(inventory)
        } catch (ValidationException e) {
            respond inventory.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'inventory.label', default: 'Inventory'), inventory.id])
                redirect inventory
            }
            '*'{ respond inventory, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        inventoryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'inventory.label', default: 'Inventory'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventory.label', default: 'Inventory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
