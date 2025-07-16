package com.mendoza.denunciaservice.service;

import com.mendoza.denunciaservice.entity.Denuncia;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DenunciaService {
    public List<Denuncia> getAll(Pageable page);
    public List<Denuncia> getAllByDni(String dni);
    public Denuncia getById(int id);
    public Denuncia create(Denuncia denuncia);
    public Denuncia update(Denuncia denuncia);
    public void delete(int id);
}
