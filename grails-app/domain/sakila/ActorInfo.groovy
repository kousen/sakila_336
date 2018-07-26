package sakila

class ActorInfo {
    Short id
    String firstName
    String lastName
    String filmInfo

    static mapping = {
        table 'actor_info'
        id column: 'actor_id'
        filmInfo type: 'text'
        version false
    }

    static constraints = {
        firstName()
        lastName()
        filmInfo()
    }
}
