package org.app.controller;

import org.app.service.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private static final Logger logger = LoggerFactory.getLogger(controller.class);

    @Autowired
    service serviceDao;

    @GetMapping("/holaComoEstas")
    public ResponseEntity<String> getHolaComoEstas() {
        try {
            String hola = serviceDao.Saludar();
            return ResponseEntity.ok(hola);
        } catch (Exception e) {
            logger.error("Error en MensajeLicenciaController > getNotificacionesByUsuario: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
