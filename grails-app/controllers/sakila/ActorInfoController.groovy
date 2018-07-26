package sakila

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ActorInfoController {

    ActorInfoService actorInfoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond actorInfoService.list(params), model:[actorInfoCount: actorInfoService.count()]
    }

    def show(Long id) {
        respond actorInfoService.get(id)
    }

    def create() {
        respond new ActorInfo(params)
    }

    def save(ActorInfo actorInfo) {
        if (actorInfo == null) {
            notFound()
            return
        }

        try {
            actorInfoService.save(actorInfo)
        } catch (ValidationException e) {
            respond actorInfo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'actorInfo.label', default: 'ActorInfo'), actorInfo.id])
                redirect actorInfo
            }
            '*' { respond actorInfo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond actorInfoService.get(id)
    }

    def update(ActorInfo actorInfo) {
        if (actorInfo == null) {
            notFound()
            return
        }

        try {
            actorInfoService.save(actorInfo)
        } catch (ValidationException e) {
            respond actorInfo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'actorInfo.label', default: 'ActorInfo'), actorInfo.id])
                redirect actorInfo
            }
            '*'{ respond actorInfo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        actorInfoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'actorInfo.label', default: 'ActorInfo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'actorInfo.label', default: 'ActorInfo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
