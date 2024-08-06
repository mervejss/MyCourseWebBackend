package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.dtos.PurchaseOrSaleDTO;
import com.web.MyCourseWeb.entities.PurchaseOrSale;
import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.entities.Course;

public class PurchaseOrSaleMapper {

    public static PurchaseOrSaleDTO toDTO(PurchaseOrSale purchaseOrSale) {
        PurchaseOrSaleDTO dto = new PurchaseOrSaleDTO();
        dto.setPurchaseOrSaleID(purchaseOrSale.getPurchaseOrSaleID());
        dto.setUserID(purchaseOrSale.getUserID().getUserID());
        dto.setCourseID(purchaseOrSale.getCourseID().getCourseID());
        dto.setTransactionType(purchaseOrSale.getTransactionType().ordinal());
        dto.setStatus(purchaseOrSale.getStatus().ordinal());
        dto.setPaymentMethod(purchaseOrSale.getPaymentMethod().ordinal());
        dto.setCreatedAt(purchaseOrSale.getCreatedAt()); // Tarihi ekleyin
        dto.setUpdatedAt(purchaseOrSale.getUpdatedAt());

        return dto;
    }

    public static PurchaseOrSale toEntity(PurchaseOrSaleDTO dto) {
        PurchaseOrSale entity = new PurchaseOrSale();
        entity.setPurchaseOrSaleID(dto.getPurchaseOrSaleID());

        User user = new User();
        user.setUserID(dto.getUserID());
        entity.setUserID(user);

        Course course = new Course();
        course.setCourseID(dto.getCourseID());
        entity.setCourseID(course);

        entity.setTransactionType(PurchaseOrSale.TransactionType.values()[dto.getTransactionType()]);
        entity.setStatus(PurchaseOrSale.Status.values()[dto.getStatus()]);
        entity.setPaymentMethod(PurchaseOrSale.PaymentMethod.values()[dto.getPaymentMethod()]);
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
}
