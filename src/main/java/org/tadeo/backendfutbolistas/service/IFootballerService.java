package org.tadeo.backendfutbolistas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.tadeo.backendfutbolistas.model.Footballer;

import java.util.List;

public interface IFootballerService extends ICRUD<Footballer, Integer> {

    Page<Footballer> findPage(Pageable pageable);

    List<Footballer> findAllOrder(String param);
}
