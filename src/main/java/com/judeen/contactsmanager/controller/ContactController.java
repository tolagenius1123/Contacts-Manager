package com.judeen.contactsmanager.controller;

import com.judeen.contactsmanager.dto.ContactDto;
import com.judeen.contactsmanager.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
@AllArgsConstructor
public class ContactController {

    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDto> addContact (@RequestBody ContactDto contactDto) {
        ContactDto savedContact = contactService.addContact(contactDto);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ContactDto>> getContacts () {
        List<ContactDto> contacts = contactService.getContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContact (@PathVariable("id") Long contactId) {
        ContactDto contact = contactService.getContact(contactId);
        return ResponseEntity.ok(contact);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContactDto> updateContact (@PathVariable("id") Long contactId, @RequestBody ContactDto contactDto) {
        ContactDto updatedContact = contactService.updateContact(contactId, contactDto);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("{id}")
    public void deleteContact (@PathVariable("id") Long contactId) {
        contactService.deleteContact(contactId);
    }

}
