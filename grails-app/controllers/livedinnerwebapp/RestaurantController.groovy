package livedinnerwebapp

class RestaurantController {

    def index() {
        def drinkItems = Drinks.list()      //Fetching all drink items from DB
        def lunchItems = Lunch.list()
        def dinnerItems = Dinner.list()
        def galleryImg = Gallery.list()
        [drinkItems:drinkItems, lunchItems:lunchItems, dinnerItems:dinnerItems, galleryImg:galleryImg]
    }

    def about() {

    }

    def blog() {

    }

    def blogPost() {

    }

    def blogDetails() {

    }

    def contact() {

    }

    def messageContact() {
        String person = params.person
        String email = params.email
        String name = params.name
        String message = params.message
        String txt = """Name: ${name}
        Email: ${email}
        Message Body: ${message}"""

        if(person == "Admin") {
            //to send these to admin page
            render "Your message is sent to the Admin."
        }
        else if(person == "Manager") {
            sendMail {
                to email
                subject "Mr. ${name} sent a message"
                text txt
            }
            render "Your message is sent to the Manager."
        }
    }

    def gallery() {
        def galleryImg = Gallery.list()
        [galleryImg:galleryImg]
    }

    def getGalleryImg(Long id) {
        def galleryItem = Gallery.get(id);

        if (galleryItem != null) {
            response.contentType = galleryItem.imageContentType == null ? "image/jpeg" : galleryItem.imageContentType;
            response.contentLength = galleryItem.image == null ? 0 : galleryItem.image.size();
            response.outputStream << galleryItem.image;
        } else {
            response.contentType = "image/jpeg";
            response.contentLength = 0;
            response.outputStream << null;
        }
    }

    def menu() {
        def drinkItems = Drinks.list()      //Fetching all drink items from DB
        def lunchItems = Lunch.list()
        def dinnerItems = Dinner.list()
        [drinkItems:drinkItems, lunchItems:lunchItems, dinnerItems:dinnerItems]
    }

    def getDrinkImg(Long id) {
        def drinkItem = Drinks.get(id);

        if (drinkItem != null) {
            response.contentType = drinkItem.imageContentType == null ? "image/jpeg" : drinkItem.imageContentType;
            response.contentLength = drinkItem.image == null ? 0 : drinkItem.image.size();
            response.outputStream << drinkItem.image;
        } else {
            response.contentType = "image/jpeg";
            response.contentLength = 0;
            response.outputStream << null;
        }
    }

    def getLunchImg(Long id) {
        def lunchItem = Lunch.get(id);

        if (lunchItem != null) {
            response.contentType = lunchItem.imageContentType == null ? "image/jpeg" : lunchItem.imageContentType;
            response.contentLength = lunchItem.image == null ? 0 : lunchItem.image.size();
            response.outputStream << lunchItem.image;
        } else {
            response.contentType = "image/jpeg";
            response.contentLength = 0;
            response.outputStream << null;
        }
    }

    def getDinnerImg(Long id) {
        def DinnerItem = Dinner.get(id);

        if (DinnerItem != null) {
            response.contentType = DinnerItem.imageContentType == null ? "image/jpeg" : DinnerItem.imageContentType;
            response.contentLength = DinnerItem.image == null ? 0 : DinnerItem.image.size();
            response.outputStream << DinnerItem.image;
        } else {
            response.contentType = "image/jpeg";
            response.contentLength = 0;
            response.outputStream << null;
        }
    }

    def reservation() {

    }

    def staff() {
        def staff = Staff.list()
        [staff:staff]
    }

    def addStaff() {

    }

    def getStaffImg(Long id) {
        def staff = Staff.get(id);

        if (staff != null) {
            response.contentType = staff.imageContentType == null ? "image/jpeg" : staff.imageContentType;
            response.contentLength = staff.image == null ? 0 : staff.image.size();
            response.outputStream << staff.image;
        } else {
            response.contentType = "image/jpeg";
            response.contentLength = 0;
            response.outputStream << null;
        }
    }

    def addProduct() {

    }

    def addGallery() {

    }

    def reservationFunctionality() {        //Function for confirming reservation through email
        String email = params.email
        String name = params.name
        String phone = params.phone
        String noOfPerson = params.NoofPerson
        String date = params.resDate
        String time = params.resTime
        String txt = """Dear sir,
        Your reservation at Live Dinner Restaurant has been confirmed.
        
        Name: ${name}
        Phone no.: ${phone}
        No. of Person: ${noOfPerson}
        Date: ${date}
        Time: ${time}
        
        Thanks for your reservation. 
        """

        sendMail {
            to email
            subject "Reservation at Live Dinner Restaurant"
            text txt
        }
        render "Reservation confirmed at "+new Date()
    }

    def addItem() {                         //Function for adding Menu item to database
        def imageMap = [:]
        byte[] photo = request.getFile("userImage").bytes   //converting photo into bytes
        String type = request.getFile("userImage").contentType

        if (type == null || !(type =~ "image/")) {
            imageMap.put("image", null)
            imageMap.put("imageContentType", null)
        } else {
            imageMap.put("image", photo)
            imageMap.put("imageContentType", type)
        }

        String name = params.name
        String details = params.details
        String price = params.price

        imageMap.put("name", name)
        imageMap.put("details", details)
        imageMap.put("price", price)

        def newUser = new Dinner(imageMap)
        if(!newUser.validate()) {
            render "Problem saving item"
        }
        else {
            Dinner create_user = new Dinner(imageMap)
            create_user.save()
            render "Item saved successfully"
        }
    }

    def addToGallery() {
        def imgMap = [:]
        byte[] photo = request.getFile("userImg").bytes     //converting photo into bytes
        String type = request.getFile("userImg").contentType

        if (type == null || !(type =~ "image/")) {
            imgMap.put("image", null)
            imgMap.put("imageContentType", null)
        } else {
            imgMap.put("image", photo)
            imgMap.put("imageContentType", type)
        }


        def newUser = new Gallery(imgMap)
        if(!newUser.validate()) {
            render "Problem saving item"
        }
        else {
            Gallery create_user = new Gallery(imgMap)
            create_user.save()
            render "Item saved successfully"
        }
    }

    def addToStaff() {
        def imgMap = [:]
        byte[] photo = request.getFile("staffImage").bytes     //converting photo into bytes
        String type = request.getFile("staffImage").contentType

        if (type == null || !(type =~ "image/")) {
            imgMap.put("image", null)
            imgMap.put("imageContentType", null)
        } else {
            imgMap.put("image", photo)
            imgMap.put("imageContentType", type)
        }

        String name = params.name
        String designation = params.designation
        imgMap.put("name", name)
        imgMap.put("designation", designation)

        def newUser = new Staff(imgMap)
        if(!newUser.validate()) {
            render "Problem saving item"
        }
        else {
            Staff create_user = new Staff(imgMap)
            create_user.save()
            render "Item saved successfully"
        }
    }
}
