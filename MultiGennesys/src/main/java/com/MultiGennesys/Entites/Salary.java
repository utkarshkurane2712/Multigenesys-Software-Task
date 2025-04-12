package com.MultiGennesys.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
	
    @Id @GeneratedValue
    private Long id;
    private Double amount;

    @OneToOne(mappedBy = "salary")
    private Employee employee;

}
