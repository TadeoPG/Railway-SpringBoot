package org.tadeo.backendfutbolistas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tadeo.backendfutbolistas.dto.PositionDTO;
import org.tadeo.backendfutbolistas.model.Position;
import org.tadeo.backendfutbolistas.service.IPositionService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionController {

    private final IPositionService service;

    @Qualifier("positionMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PositionDTO>> readAll() throws Exception {
        List<PositionDTO> list = service.readAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Position obj = service.readById(id);
        return new ResponseEntity<>(convertToDTO(obj), OK);
    }

    @PostMapping
    public ResponseEntity<PositionDTO> create(@Valid @RequestBody PositionDTO dto) throws Exception {
        Position obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody PositionDTO dto) throws Exception {
        dto.setIdPosition(id);
        Position obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private PositionDTO convertToDTO(Position entity) {
        return mapper.map(entity, PositionDTO.class);
    }

    private Position convertToEntity(PositionDTO dto) {
        return mapper.map(dto, Position.class);
    }
}
