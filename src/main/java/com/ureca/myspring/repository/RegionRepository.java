package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ureca.myspring.dto.RegionDTO;

public interface RegionRepository extends JpaRepository<RegionDTO, Long> {

    @Query("SELECT DISTINCT r.zone FROM RegionDTO r")
    List<String> findDistinctZone();
    
    @Query("SELECT DISTINCT r.city FROM RegionDTO r WHERE r.zone = :zone")
    List<String> findDistinctCity(@Param("zone") String zone);
    
    @Query("SELECT DISTINCT r.district FROM RegionDTO r WHERE r.city = :city")
    List<String> findDistinctDistrictByCity(@Param("city") String city);

    @Query("SELECT DISTINCT r.district FROM RegionDTO r WHERE r.zone = :zone")
    List<String> findDistinctDistrictByZone(@Param("zone") String zone);

    @Query("SELECT DISTINCT r.neighborhood FROM RegionDTO r WHERE r.district = :district")
    List<String> findDistinctNeighborhoodByDistrict(@Param("district") String district);

    @Query("SELECT DISTINCT r.neighborhood FROM RegionDTO r WHERE r.city = :city")
    List<String> findDistinctNeighborhoodByCity(@Param("city") String city);
}
