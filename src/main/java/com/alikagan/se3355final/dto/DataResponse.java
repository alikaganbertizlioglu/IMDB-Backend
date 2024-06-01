package com.alikagan.se3355final.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataResponse<Type> {
    private Type data;
    private String message;

}
