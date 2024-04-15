package org.tadeo.backendfutbolistas.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tadeo.backendfutbolistas.model.Position;
import org.tadeo.backendfutbolistas.repository.IGenericRepo;
import org.tadeo.backendfutbolistas.repository.IPositionRepo;
import org.tadeo.backendfutbolistas.service.IPositionService;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl extends CRUDImpl<Position, Integer> implements IPositionService {

    private final IPositionRepo repo;

    @Override
    protected IGenericRepo<Position, Integer> getRepo() {
        return repo;
    }
}
