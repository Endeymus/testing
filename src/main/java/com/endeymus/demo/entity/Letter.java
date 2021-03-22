package com.endeymus.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Класс "Символ" с полями <b>letter</b> и <b>count</b>
 * @author Mark Shamray
 */
@Data
public class Letter implements Serializable {
    private Character letter;
    private Integer count;
}
