import java.util.Collections;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

import javax.ws.rs.core.MediaType;

@Path("/test")
public class Service {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserBean read() {
        UserBean userBean = new UserBean();
        userBean.setFirstName("first");
        userBean.setLastName("last");
        return userBean;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(UserBean userBean) {
    	System.out.println("userBean="+userBean);
        return "success";
    }
}
