package com.ureca.myspring.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="region")
public class RegionDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          
    private String zone;       // 시/도
    private String city;           // 시/도
    private String district;           // 구/군
    private String neighborhood;           // 동/읍/면/리
}
