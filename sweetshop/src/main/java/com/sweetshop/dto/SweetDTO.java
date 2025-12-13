package com.sweetshop.dto;

import java.math.BigDecimal;

public record SweetDTO(String name, String category, BigDecimal price, Integer quantity) {

}
