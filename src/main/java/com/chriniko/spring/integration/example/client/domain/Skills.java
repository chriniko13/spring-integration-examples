package com.chriniko.spring.integration.example.client.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@XmlRootElement
public class Skills {

    private List<String> skill;
}
