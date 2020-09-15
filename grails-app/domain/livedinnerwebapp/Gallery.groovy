package livedinnerwebapp

class Gallery {
    byte[] image
    String imageContentType

    static constraints = {
        image nullable: true, blank: false, maxSize: 1024 * 1024 * 20  //20MB
        imageContentType nullable: true, blank: true
    }

    static mapping = {
        image column: 'image', sqlType: 'longblob'
    }
}
