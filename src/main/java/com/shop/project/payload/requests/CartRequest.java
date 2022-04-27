package com.shop.project.payload.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CartRequest {
    @NotBlank
    private Long    productId;

    @NotBlank
    private String  email;
}
