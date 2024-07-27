package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.PurchaseOrSale;
import com.web.MyCourseWeb.services.PurchaseOrSaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class PurchaseOrSaleController {

    private final PurchaseOrSaleService purchaseOrSaleService;

    public PurchaseOrSaleController(PurchaseOrSaleService purchaseOrSaleService) {
        this.purchaseOrSaleService = purchaseOrSaleService;
    }

    @GetMapping
    public List<PurchaseOrSale> getAllTransactions() {
        return purchaseOrSaleService.getAllTransactions();
    }

    @PostMapping
    public PurchaseOrSale createTransaction(@RequestBody PurchaseOrSale newTransaction) {
        return purchaseOrSaleService.saveOneTransaction(newTransaction);
    }

    @GetMapping("/{transactionID}")
    public ResponseEntity<PurchaseOrSale> getOneTransaction(@PathVariable Long transactionID) {
        PurchaseOrSale transaction = purchaseOrSaleService.getOneTransaction(transactionID);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{transactionID}")
    public ResponseEntity<PurchaseOrSale> updateOneTransaction(@PathVariable Long transactionID, @RequestBody PurchaseOrSale newTransaction) {
        PurchaseOrSale updatedTransaction = purchaseOrSaleService.updateOneTransaction(transactionID, newTransaction);
        return updatedTransaction != null ? ResponseEntity.ok(updatedTransaction) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{transactionID}")
    public ResponseEntity<Void> deleteOneTransaction(@PathVariable Long transactionID) {
        purchaseOrSaleService.deleteOneTransaction(transactionID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteAllPurchaseOrSale() {
        purchaseOrSaleService.deleteAllPurchaseOrSale();
    }

}
