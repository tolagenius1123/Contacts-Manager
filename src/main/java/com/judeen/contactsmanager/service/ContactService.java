package com.judeen.contactsmanager.service;

import com.judeen.contactsmanager.dto.ContactDto;

import java.util.List;

public interface ContactService {

    ContactDto addContact (ContactDto contactDto);

    List<ContactDto> getContacts ();

    ContactDto getContact (Long contactId);

    ContactDto updateContact (Long contactId, ContactDto contactDto);

    void deleteContact (Long contactId);
}
