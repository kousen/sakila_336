package sakila

enum Rating {
    G('G'), PG('PG'), PG_13('PG-13'), R('R'), NC_17('NC-17')

    private String id

    Rating(String id) {
        this.id = id
    }

    String getId() { id }
    String toString() { name() }

    static Rating fromValue(String name) {
        values().find { it.id == name }
    }

}

