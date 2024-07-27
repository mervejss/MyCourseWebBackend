package com.web.MyCourseWeb.requests;

import lombok.Data;

@Data
public class UserRequest {

    Long userID;
    Long userRoleID;
    String userName;
    String userMail;
    String userPassword;
    Long purchaseOrSale;
    Long CourseIDofTheUser;


}
