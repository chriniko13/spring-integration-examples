package com.chriniko.spring.integration.example.client.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@XmlRootElement
public class Programmer {

    private Skills skills;

    private String initials;

    private String surname;

    private String firstname;

    private String ranking;

}
