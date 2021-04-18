package com.justdev.Shoppe.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private long customerId;
    private String name;
    private long activePoints;

}
