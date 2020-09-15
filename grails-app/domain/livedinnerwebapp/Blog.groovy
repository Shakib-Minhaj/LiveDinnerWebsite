package livedinnerwebapp

class Blog {
    static hasMany = [comments: Comment , replys: Reply]
    String category
    String title
    String date = new Date()
    String details
    byte[] image;
    String imageContentType;

    static constraints = {
        image nullable: true, blank: true, maxSize: 1024 * 1024 * 20; //20MB
        imageContentType nullable: true, blank: true;
    }

    static mapping = {
        details    sqlType: 'longText'
        image column: 'image', sqlType: 'longblob'
    }
}

class Comment {
    String text
    String name
    String email
    String date = new Date()
    static belongsTo = [Blog]
    static hasMany = [replies: Reply]

    String toString(){
        return text
    }
    static mapping = {
        text sqlType: "longText"
    }

    static constraints = {
        text unique: false
    }
}

class Reply {
    String reply
    String name
    String email
    String time
    String date = new Date()
    static belongsTo = [Blog, Comment]
    Blog  blogsInReply
    Comment commentInReply
    static mapping = {
        reply   sqlType: 'longText'
    }
}
