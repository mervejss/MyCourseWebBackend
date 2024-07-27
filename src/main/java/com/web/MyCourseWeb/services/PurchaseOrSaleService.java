package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.PurchaseOrSale;
import com.web.MyCourseWeb.repos.PurchaseOrSaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrSaleService {

    private final PurchaseOrSaleRepository purchaseOrSaleRepository;

    public PurchaseOrSaleService(PurchaseOrSaleRepository purchaseOrSaleRepository) {
        this.purchaseOrSaleRepository = purchaseOrSaleRepository;
    }

    public List<PurchaseOrSale> getAllTransactions() {
        return purchaseOrSaleRepository.findAll();
    }

    public PurchaseOrSale saveOneTransaction(PurchaseOrSale newTransaction) {
        return purchaseOrSaleRepository.save(newTransaction);
    }

    public PurchaseOrSale getOneTransaction(Long transactionID) {
        return purchaseOrSaleRepository.findById(transactionID).orElse(null);
    }

    public PurchaseOrSale updateOneTransaction(Long transactionID, PurchaseOrSale newTransaction) {
        Optional<PurchaseOrSale> transaction = purchaseOrSaleRepository.findById(transactionID);
        if (transaction.isPresent()) {
            PurchaseOrSale foundTransaction = transaction.get();
            foundTransaction.setUser(newTransaction.getUser());
            foundTransaction.setCourseID(newTransaction.getCourseID());
            foundTransaction.setTransactionType(newTransaction.getTransactionType());
            foundTransaction.setStatus(newTransaction.getStatus());
            foundTransaction.setPaymentMethod(newTransaction.getPaymentMethod());
            purchaseOrSaleRepository.save(foundTransaction);
            return foundTransaction;
        } else {
            return null;
        }
    }

    public void deleteOneTransaction(Long transactionID) {

        purchaseOrSaleRepository.deleteById(transactionID);
    }

    public void deleteAllPurchaseOrSale() {
        purchaseOrSaleRepository.deleteAll();
    }
}
