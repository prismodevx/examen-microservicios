package com.mendoza.denunciaservice.service.impl;

import com.mendoza.denunciaservice.entity.Denuncia;
import com.mendoza.denunciaservice.repository.DenunciaRepository;
import com.mendoza.denunciaservice.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DenunciaServiceImpl implements DenunciaService {
    @Autowired
    private DenunciaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> getAll(Pageable page) {
        try {
            List<Denuncia> registros = repository.findAll(page).toList();
            return registros;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> getAllByDni(String dni) {
        try {
            List<Denuncia> registros = repository.findByDni(dni);
            return registros;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Denuncia getById(int id) {
        try {
            Denuncia registro = repository.findById(id).orElseThrow();
            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Denuncia create(Denuncia denuncia) {
        try {
            Denuncia registro = repository.save(denuncia);
            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Denuncia update(Denuncia denuncia) {
        try {
            Denuncia registro = repository.findById(denuncia.getId()).orElseThrow();
            registro.setDni(denuncia.getDni());
            registro.setFecha(denuncia.getFecha());
            registro.setTitulo(denuncia.getTitulo());
            registro.setDireccion(denuncia.getDireccion());
            registro.setDescripcion(denuncia.getDescripcion());
            repository.save(registro);
            return registro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
