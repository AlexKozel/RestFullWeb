package com.restFull.restfullwebservices.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@ApiModel(description = "All details about user.")
public class User  {

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private Integer userId;

    @ApiModelProperty( notes= "Name must be longer then 2")
    @Size(min=2, message = "Name must be longer than 2")
    private String name;

    DateFormat df = new SimpleDateFormat("DD MM YYYY");

    @Past(message = "Wrong format of date")
    @ApiModelProperty(notes = "Date should be in the past")
    private Date birthDate;

   public User(Integer id, String name, Date birthDate){
       super();
        this.userId = id;
        this.name = name;
        this.birthDate = birthDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}


//    import org.springframework.hateoas.EntityModel;
//            import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//        EntityModel<User> model = new EntityModel<>(user);
//        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//        model.add(linkTo.withRel("all-users"));