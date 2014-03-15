tomee-jackson-test
==================

This is a test demonstrating a problem with Jackson and JAXB under Apache TomEE 1.6.

The Service class implements a JAX-RS resource with path /test.

The following method works as expected:

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserBean read() {
        UserBean userBean = new UserBean();
        userBean.setFirstName("first");
        userBean.setLastName("last");
        return userBean;
    }

Producing the following output:

    {"firstName":"first","lastName":"last"}

However, this method never executes:

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(UserBean userBean) {
    	System.out.println("userBean="+userBean);
        return "success";
    }

The following JS code in createUser.html is used to pass JSON to the Service class.

    user = {};
    user.firstName = document.getElementById('firstName').value;
    user.lastName = document.getElementById('lastName').value;
            
    // Submit the form in the background
    var oReq = new XMLHttpRequest();
    oReq.onload = reqListener;

    url = "http://localhost:8080/tomee-jackson-test/test";
    oReq.open("post", url, true);
    oReq.setRequestHeader("Content-type", "application/json");
    oReq.send(JSON.stringify(user));
		
The JS execution completes, but the println in the Service class does not execute, nor are any exceptions thrown.

Note: createUser.html does not work inside of TomEE.  Simply open the file itself in the web browser, i.e. find the file and double-click on it.
