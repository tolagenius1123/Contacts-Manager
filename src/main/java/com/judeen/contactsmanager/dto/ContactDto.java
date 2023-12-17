package com.judeen.contactsmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDto {

    private Long contactId;

    private String fullName;

    private String email;

    private String phoneNumber;
}
