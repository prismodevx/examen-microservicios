package com.mendoza.denunciaservice.repository;

import com.mendoza.denunciaservice.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
}
