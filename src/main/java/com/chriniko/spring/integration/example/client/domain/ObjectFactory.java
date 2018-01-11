package com.chriniko.spring.integration.example.client.domain;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Programmer createProgrammer() {
        return new Programmer();
    }

    public Programmers createProgrammers() {
        return new Programmers();
    }

    public Skills createSkills() {
        return new Skills();
    }
}
