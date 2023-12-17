package com.judeen.contactsmanager.service.Impl;

import com.judeen.contactsmanager.dto.ContactDto;
import com.judeen.contactsmanager.entity.Contact;
import com.judeen.contactsmanager.exception.ContactNotFoundException;
import com.judeen.contactsmanager.repository.ContactRepository;
import com.judeen.contactsmanager.service.ContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    private ModelMapper modelMapper;

    @Override
    public ContactDto addContact(ContactDto contactDto) {
        Contact newContact = new Contact();
        newContact.setFullName(contactDto.getFullName());
        newContact.setEmail(contactDto.getEmail());
        newContact.setPhoneNumber(contactDto.getPhoneNumber());

        Contact savedContact = contactRepository.save(newContact);
        return modelMapper.map(savedContact, ContactDto.class);
    }

    @Override
    public List<ContactDto> getContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map((contact) -> modelMapper.map(contact, ContactDto.class)).collect(Collectors.toList());
    }

    @Override
    public ContactDto getContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public ContactDto updateContact(Long contactId, ContactDto contactDto) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        contact.setFullName(contactDto.getFullName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhoneNumber(contactDto.getPhoneNumber());

        Contact updatedContact = contactRepository.save(contact);
        return modelMapper.map(updatedContact, ContactDto.class);
    }

    @Override
    public void deleteContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
        contactRepository.delete(contact);
    }
}
