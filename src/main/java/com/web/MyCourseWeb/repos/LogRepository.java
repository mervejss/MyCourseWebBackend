package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LogRepository  extends JpaRepository<Log,Long>{

    List<Log> findByUserID_UserID(Long userID);

}
