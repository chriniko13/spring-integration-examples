package com.chriniko.spring.integration.example.client.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@XmlRootElement
public class Programmers {

    private List<Programmer> programmer;

    private String info;
}
