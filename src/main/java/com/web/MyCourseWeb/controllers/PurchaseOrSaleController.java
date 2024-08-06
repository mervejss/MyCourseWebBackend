package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.PurchaseOrSaleDTO;

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

    // Tüm işlemleri getir
    @GetMapping
    public List<PurchaseOrSaleDTO> getAllTransactions() {
        return purchaseOrSaleService.getAllTransactions();
    }

    // Yeni bir işlem oluştur
    @PostMapping
    public PurchaseOrSaleDTO createTransaction(@RequestBody PurchaseOrSaleDTO newTransactionDTO) {
        return purchaseOrSaleService.saveOneTransaction(newTransactionDTO);
    }

    // Tek bir işlemi getir
    @GetMapping("/{transactionID}")
    public ResponseEntity<PurchaseOrSaleDTO> getOneTransaction(@PathVariable Long transactionID) {
        PurchaseOrSaleDTO transactionDTO = purchaseOrSaleService.getOneTransaction(transactionID);
        return transactionDTO != null ? ResponseEntity.ok(transactionDTO) : ResponseEntity.notFound().build();
    }

    // Var olan bir işlemi güncelle
    @PutMapping("/{transactionID}")
    public ResponseEntity<PurchaseOrSaleDTO> updateOneTransaction(@PathVariable Long transactionID, @RequestBody PurchaseOrSaleDTO newTransactionDTO) {
        PurchaseOrSaleDTO updatedTransactionDTO = purchaseOrSaleService.updateOneTransaction(transactionID, newTransactionDTO);
        return updatedTransactionDTO != null ? ResponseEntity.ok(updatedTransactionDTO) : ResponseEntity.notFound().build();
    }

    // Tek bir işlemi sil
    @DeleteMapping("/{transactionID}")
    public ResponseEntity<Void> deleteOneTransaction(@PathVariable Long transactionID) {
        purchaseOrSaleService.deleteOneTransaction(transactionID);
        return ResponseEntity.noContent().build();
    }

    // Tüm işlemleri sil
    @DeleteMapping
    public void deleteAllPurchaseOrSale() {
        purchaseOrSaleService.deleteAllPurchaseOrSale();
    }

    // Belirli bir kullanıcıya ait tüm işlemleri getir
    // Belirli bir kullanıcıya ait tüm işlemleri getir
    @GetMapping("/user")
    public List<PurchaseOrSaleDTO> getTransactionsByUserID(@RequestParam Long userID) {
        return purchaseOrSaleService.getTransactionsByUserID(userID);
    }

    // Update status of a transaction
    @PatchMapping("/{transactionID}/status")
    public ResponseEntity<PurchaseOrSaleDTO> updateTransactionStatus(
            @PathVariable Long transactionID,
            @RequestParam int status) {
        System.out.println("Received status update: " + status); // Debugging
        PurchaseOrSaleDTO updatedTransactionDTO = purchaseOrSaleService.updateTransactionStatus(transactionID, status);
        return updatedTransactionDTO != null ? ResponseEntity.ok(updatedTransactionDTO) : ResponseEntity.notFound().build();
    }
}
