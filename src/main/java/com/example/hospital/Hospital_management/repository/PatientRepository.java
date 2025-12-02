package com.example.hospital.Hospital_management.repository;

import com.example.hospital.Hospital_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//even if we don't use Repository its ok as , its an interface and in other classes it will implemented no beans will be created
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
