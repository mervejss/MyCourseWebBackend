package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.LogDTO;
import com.web.MyCourseWeb.services.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    // Tüm logları getir
    @GetMapping
    public List<LogDTO> getAllLogs() {
        return logService.getAllLogs();
    }

    // Yeni bir log oluştur
    @PostMapping
    public LogDTO createLog(@RequestBody LogDTO newLogDTO) {
        return logService.saveOneLog(newLogDTO);
    }

    // Tek bir logu getir
    @GetMapping("/{logID}")
    public ResponseEntity<LogDTO> getOneLog(@PathVariable Long logID) {
        LogDTO logDTO = logService.getOneLog(logID);
        return logDTO != null ? ResponseEntity.ok(logDTO) : ResponseEntity.notFound().build();
    }

    // Var olan bir logu güncelle
    @PutMapping("/{logID}")
    public ResponseEntity<LogDTO> updateOneLog(@PathVariable Long logID, @RequestBody LogDTO newLogDTO) {
        LogDTO updatedLogDTO = logService.updateOneLog(logID, newLogDTO);
        return updatedLogDTO != null ? ResponseEntity.ok(updatedLogDTO) : ResponseEntity.notFound().build();
    }

    // Tek bir logu sil
    @DeleteMapping("/{logID}")
    public ResponseEntity<Void> deleteOneLog(@PathVariable Long logID) {
        logService.deleteOneLog(logID);
        return ResponseEntity.noContent().build();
    }

    // Tüm logları sil
    @DeleteMapping
    public void deleteAllLogs() {
        logService.deleteAllLogs();
    }

    // Belirli bir kullanıcının loglarını getir
    @GetMapping("/user/{userID}")
    public List<LogDTO> getLogsByUser(@PathVariable Long userID) {
        return logService.getLogsByUser(userID);
    }

}
