package com.judeen.contactsmanager.repository;

import com.judeen.contactsmanager.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
