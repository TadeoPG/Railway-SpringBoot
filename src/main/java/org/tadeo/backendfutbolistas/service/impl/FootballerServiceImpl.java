package org.tadeo.backendfutbolistas.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.tadeo.backendfutbolistas.model.Footballer;
import org.tadeo.backendfutbolistas.repository.IFootballerRepo;
import org.tadeo.backendfutbolistas.repository.IGenericRepo;
import org.tadeo.backendfutbolistas.service.IFootballerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl extends CRUDImpl<Footballer, Integer> implements IFootballerService {

    private final IFootballerRepo repo;

    @Override
    protected IGenericRepo<Footballer, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Footballer> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Footballer> findAllOrder(String param) {
        return List.of();
    }
}
