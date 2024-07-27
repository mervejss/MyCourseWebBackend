package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.Log;
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

    @GetMapping
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @PostMapping
    public Log createLog(@RequestBody Log newLog) {
        return logService.saveOneLog(newLog);
    }

    @GetMapping("/{logID}")
    public ResponseEntity<Log> getOneLog(@PathVariable Long logID) {
        Log log = logService.getOneLog(logID);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{logID}")
    public ResponseEntity<Log> updateOneLog(@PathVariable Long logID, @RequestBody Log newLog) {
        Log updatedLog = logService.updateOneLog(logID, newLog);
        return updatedLog != null ? ResponseEntity.ok(updatedLog) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{logID}")
    public ResponseEntity<Void> deleteOneLog(@PathVariable Long logID) {
        logService.deleteOneLog(logID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteAllLogs() {
        logService.deleteAllLogs();
    }

}
