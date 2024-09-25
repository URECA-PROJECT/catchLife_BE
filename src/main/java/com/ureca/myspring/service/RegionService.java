package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.RegionDTO;
import com.ureca.myspring.repository.RegionRepository;

@Service
public class RegionService {
	@Autowired
	private RegionRepository regionRepository ;
	
	public List<RegionDTO> listRegion() {
		return regionRepository.findAll();
	}
	
	// 모든 zone 조회
	public List<String> listZones() {
	    return regionRepository.findDistinctZone();
	}
	
	// 모든 city 조회
	public List<String> listCities(String zone) {
	    return regionRepository.findDistinctCity(zone);
	}
	
	// 모든 district 조회 (city > district)
	public List<String> listDistrictToCity(String city) {
	    return regionRepository.findDistinctDistrictByCity(city);
	}

	// 모든 neighborhood 조회 (district > neighborhood)
	public List<String> listNeighborhoodToDistrict(String district) {
	    return regionRepository.findDistinctNeighborhoodByDistrict(district);
	}

	// 모든 district 조회 (zone > district)
	public List<String> listDistrictToZone(String zone) {
	    return regionRepository.findDistinctDistrictByZone(zone);
	}

	// 모든 neighborhood 조회 (city > neighborhood)
	public List<String> listNeighborhoodToCity(String city) {
	    return regionRepository.findDistinctNeighborhoodByCity(city);
	}

}
