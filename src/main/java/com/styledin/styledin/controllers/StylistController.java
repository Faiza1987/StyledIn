package com.styledin.styledin.controllers;

import com.styledin.styledin.models.Stylist;
import com.styledin.styledin.services.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/stylists")
public class StylistController {

    @Autowired
    private StylistService stylistService;

    // Create
    @PostMapping
    public ResponseEntity<Stylist> createStylist(@RequestBody Stylist createStylistRequest) {
        try {
            Stylist newStylist = stylistService.createStylist(createStylistRequest);
            return ResponseEntity.ok(newStylist);
        } catch (Exception e){
            System.out.println("Unable to create stylist because of exception: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Read
    // get all stylists
    @GetMapping
    public ResponseEntity<List<Stylist>> getAllStylists() {
        try {
            List<Stylist> allStylists = stylistService.getAllStylists();
            return ResponseEntity.ok(allStylists);
        } catch (Exception e) {
            System.out.println("Unable to retrieve all stylists because of error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // get specific stylist
    @GetMapping("/id")
    public ResponseEntity<Stylist> getStylist(@RequestBody UUID stylistId){
        try {
            Stylist stylist = stylistService.getStylist(stylistId);
            return ResponseEntity.ok(stylist);
        } catch (Exception e) {
            System.out.println("Unable to retrieve stylist with id: " + stylistId + " because of error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // Update
    @PatchMapping("/id")
    public ResponseEntity<Stylist> updateStylist(@RequestBody Stylist updateStylistRequest) {
        try {
            Stylist updatedStylist = stylistService.updateStylist(updateStylistRequest);
            return ResponseEntity.ok(updatedStylist);
        } catch (Exception e) {
            System.out.println("Unable to update stylist with id: " + updateStylistRequest.getId() + " because of error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/id")
    public ResponseEntity<Stylist> deleteStylist(@RequestBody UUID stylistId) {
        try {
            Stylist deletedStylist = stylistService.deleteStylist(stylistId);
            return ResponseEntity.ok(deletedStylist);
        } catch (Exception e) {
            System.out.println("Unable to delete stylist with id: " + stylistId + " because of error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
