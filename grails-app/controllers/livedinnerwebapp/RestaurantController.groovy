package livedinnerwebapp

class RestaurantController {

    def index() {

    }

    def about() {

    }

    def blog() {

    }

    def blogDetails() {

    }

    def contact() {

    }

    def gallery() {

    }

    def menu() {
        def fetched_value = Drinks.list()  //Fetching all from database
        //render(view:'postOnly', model: [fetched_value:fetched_value])
        def imgMap = [:]
        def imgList = []
        Integer i = 0
        for(item in fetched_value) {
            //imgMap.put("image", null)
            ByteArrayInputStream bis = new ByteArrayInputStream(item.image[i])
            imgMap.put("bis", bis)
            imgMap.put("name", item.name)
            imgMap.put("details", item.details)
            imgMap.put("price", item.price)
            imgList[i] = imgMap

            i++
        //def user = User.get(id);
        //if (user != null) {
          //  response.contentType = user.imageContentType == null ? "image/jpeg" : user.imageContentType;
           // response.contentLength = user.image == null ? 0 : user.image.size();
           // response.outputStream << user.image;
        //} else {
          //  response.contentType = "image/jpeg";
            //response.contentLength = 0;
            //response.outputStream << null;
        }

        render(view:'menu', model: [imgMap:imgMap])

               // <img src="${createLink(action: 'getImage', controller: 'user', id: 1)}"/>
    }

    def reservation() {

    }

    def staff() {

    }

    def addProduct() {

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
        byte[] photo = request.getFile("userImage").bytes
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

        def newUser = new Drinks(imageMap)
        if(!newUser.validate()) {
            render "Problem saving item"
        }
        else {
            Drinks create_user = new Drinks(imageMap)
            create_user.save()
            render "Item saved successfully"
        }
    }
}
