package com.duoc.alertservice.repository;

import com.duoc.alertservice.model.AlertaEmergencia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaEmergenciaRepository extends JpaRepository<AlertaEmergencia, Long> {
    List<AlertaEmergencia> findByNivelRiesgo(AlertaEmergencia.NivelRiesgo nivelRiesgo);
}
