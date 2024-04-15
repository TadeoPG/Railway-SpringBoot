package org.tadeo.backendfutbolistas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tadeo.backendfutbolistas.dto.FootballerDTO;
import org.tadeo.backendfutbolistas.model.Footballer;
import org.tadeo.backendfutbolistas.service.IFootballerService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/footballers")
@RequiredArgsConstructor
public class FootballerController {

    private final IFootballerService service;

    @Qualifier("footballerMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<FootballerDTO>> readAll() throws Exception {
        List<FootballerDTO> list = service.readAll().stream().map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FootballerDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Footballer obj = service.readById(id);
        return new ResponseEntity<>(convertToDTO(obj), OK);
    }

    @PostMapping
    public ResponseEntity<FootballerDTO> create(@Valid @RequestBody FootballerDTO dto) throws Exception {
        Footballer obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FootballerDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody FootballerDTO dto) throws Exception {
        dto.setIdFootballer(id);
        Footballer obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Footballer>> findPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Footballer> pageResponse = service.findPage(pageRequest);
        return new ResponseEntity<>(pageResponse, OK);
    }

    private FootballerDTO convertToDTO(Footballer entity) {
        return mapper.map(entity, FootballerDTO.class);
    }

    private Footballer convertToEntity(FootballerDTO dto) {
        return mapper.map(dto, Footballer.class);
    }
}
