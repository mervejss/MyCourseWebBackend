package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.PurchaseOrSale;
import com.web.MyCourseWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PurchaseOrSaleRepository extends JpaRepository<PurchaseOrSale,Long>{
    List<PurchaseOrSale> findByUserID(User userID);

}
