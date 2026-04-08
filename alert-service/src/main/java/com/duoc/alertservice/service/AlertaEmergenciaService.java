package com.duoc.alertservice.service;

import com.duoc.alertservice.model.AlertaEmergencia;
import com.duoc.alertservice.repository.AlertaEmergenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaEmergenciaService {
    @Autowired
    private AlertaEmergenciaRepository alertaEmergenciaRepository;

    public List<AlertaEmergencia> findAll() {
        return alertaEmergenciaRepository.findAll();
    }

    public AlertaEmergencia findById(Long id) {
        return alertaEmergenciaRepository.findById(id).orElse(null);
    }

    public List<AlertaEmergencia> findByNivelRiesgo(AlertaEmergencia.NivelRiesgo nivelRiesgo) {
        return alertaEmergenciaRepository.findByNivelRiesgo(nivelRiesgo);
    }

    public AlertaEmergencia save(AlertaEmergencia alerta) {
        return alertaEmergenciaRepository.save(alerta);
    }

    public void deleteById(Long id) {
        alertaEmergenciaRepository.deleteById(id);
    }
}
