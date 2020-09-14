package livedinnerwebapp

class Lunch {
    String name
    String details
    String price
    byte[] image
    String imageContentType

    static constraints = {
        image nullable: true, blank: false, maxSize: 1024 * 1024 * 20  //20MB
        details nullable: true, blank: false
        name nullable: true, blank: false
        price nullable: true, blank: false
        imageContentType nullable: true, blank: true
    }

    static mapping = {
        image column: 'image', sqlType: 'longblob'
    }
}
