package br.com.pdv.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RestController
public abstract class AbstractController<T extends Serializable> {

    @Getter
    @Setter
    private Class<T> clazz;

}