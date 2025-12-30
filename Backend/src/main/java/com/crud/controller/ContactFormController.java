package com.crud.controller;

import com.crud.entity.ContactForm;
import com.crud.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-form")
public class ContactFormController {

    @Autowired
    private ContactFormService contactFormService;

  @PostMapping("/add")
  public ResponseEntity<ContactForm> submitContactForm(@RequestBody ContactForm form) {
      return ResponseEntity.ok(contactFormService.submitContactForm(form));
  }

    @GetMapping("/all")
    public ResponseEntity<List<ContactForm>> getAllContactForms(){
      return ResponseEntity.ok(contactFormService.getAllContactForms());
}
}
