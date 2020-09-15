package livedinnerwebapp

class Staff {
    String name
    String designation
    byte[] image
    String imageContentType

    static constraints = {
        image nullable: true, blank: false, maxSize: 1024 * 1024 * 20  //20MB
        designation nullable: true, blank: false
        name nullable: true, blank: false
        imageContentType nullable: true, blank: true
    }

    static mapping = {
        image column: 'image', sqlType: 'longblob'
    }
}
