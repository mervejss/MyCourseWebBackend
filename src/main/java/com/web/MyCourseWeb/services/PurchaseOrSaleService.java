package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.PurchaseOrSaleDTO;
import com.web.MyCourseWeb.entities.PurchaseOrSale;
import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.entities.Course;
import com.web.MyCourseWeb.mappers.PurchaseOrSaleMapper;
import com.web.MyCourseWeb.repos.PurchaseOrSaleRepository;
import com.web.MyCourseWeb.repos.UserRepository;
import com.web.MyCourseWeb.repos.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseOrSaleService {

    private final PurchaseOrSaleRepository purchaseOrSaleRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public PurchaseOrSaleService(PurchaseOrSaleRepository purchaseOrSaleRepository,
                                 UserRepository userRepository,
                                 CourseRepository courseRepository) {
        this.purchaseOrSaleRepository = purchaseOrSaleRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    // Tüm işlemleri getir
    public List<PurchaseOrSaleDTO> getAllTransactions() {
        return purchaseOrSaleRepository.findAll().stream()
                .map(PurchaseOrSaleMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Tek bir işlemi getir
    public PurchaseOrSaleDTO getOneTransaction(Long transactionID) {
        return purchaseOrSaleRepository.findById(transactionID)
                .map(PurchaseOrSaleMapper::toDTO)
                .orElse(null);
    }

    // Yeni bir işlem oluştur
    public PurchaseOrSaleDTO saveOneTransaction(PurchaseOrSaleDTO newTransactionDTO) {
        PurchaseOrSale newTransaction = PurchaseOrSaleMapper.toEntity(newTransactionDTO);

        // User ve Course ID ile ilgili nesneleri getir
        Optional<User> user = userRepository.findById(newTransactionDTO.getUserID());
        Optional<Course> course = courseRepository.findById(newTransactionDTO.getCourseID());

        if (user.isPresent() && course.isPresent()) {
            newTransaction.setUser(user.get());
            newTransaction.setCourseID(course.get());
        } else {
            throw new RuntimeException("User or Course not found with ID: " + newTransactionDTO.getUserID() + " or " + newTransactionDTO.getCourseID());
        }

        return PurchaseOrSaleMapper.toDTO(purchaseOrSaleRepository.save(newTransaction));
    }

    // Var olan bir işlemi güncelle
    public PurchaseOrSaleDTO updateOneTransaction(Long transactionID, PurchaseOrSaleDTO newTransactionDTO) {
        Optional<PurchaseOrSale> optionalTransaction = purchaseOrSaleRepository.findById(transactionID);
        if (optionalTransaction.isPresent()) {
            PurchaseOrSale existingTransaction = optionalTransaction.get();
            existingTransaction.setTransactionType(PurchaseOrSale.TransactionType.values()[newTransactionDTO.getTransactionType()]);
            existingTransaction.setStatus(PurchaseOrSale.Status.values()[newTransactionDTO.getStatus()]);
            existingTransaction.setPaymentMethod(PurchaseOrSale.PaymentMethod.values()[newTransactionDTO.getPaymentMethod()]);

            // User ve Course ID ile ilgili nesneleri getir
            Optional<User> user = userRepository.findById(newTransactionDTO.getUserID());
            Optional<Course> course = courseRepository.findById(newTransactionDTO.getCourseID());

            if (user.isPresent() && course.isPresent()) {
                existingTransaction.setUser(user.get());
                existingTransaction.setCourseID(course.get());
            } else {
                throw new RuntimeException("User or Course not found with ID: " + newTransactionDTO.getUserID() + " or " + newTransactionDTO.getCourseID());
            }

            existingTransaction.setCreatedAt(new Date()); // Optional, as @PrePersist will handle this
            return PurchaseOrSaleMapper.toDTO(purchaseOrSaleRepository.save(existingTransaction));
        }
        return null;
    }

    // Tek bir işlemi sil
    public void deleteOneTransaction(Long transactionID) {
        purchaseOrSaleRepository.deleteById(transactionID);
    }

    // Tüm işlemleri sil
    public void deleteAllPurchaseOrSale() {
        purchaseOrSaleRepository.deleteAll();
    }
}
