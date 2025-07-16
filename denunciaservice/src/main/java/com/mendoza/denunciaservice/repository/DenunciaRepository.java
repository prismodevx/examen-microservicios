package com.mendoza.denunciaservice.repository;

import com.mendoza.denunciaservice.entity.Denuncia;
import org.springframework.data.domain.ManagedTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    List<Denuncia> findByDni(String dni);
}
