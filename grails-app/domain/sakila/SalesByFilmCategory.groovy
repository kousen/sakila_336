package sakila

class SalesByFilmCategory {
    String category
    BigDecimal totalSales

    static mapping = {
        id name: 'category'
        version false
    }

    static constraints = {
    }
}
