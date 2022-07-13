package com.csm.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.demo.Entity.PackageEntity;

public interface PackageRepo extends JpaRepository<PackageEntity, Long>{

}
