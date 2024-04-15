package org.tadeo.backendfutbolistas.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("footballerMapper")
    public ModelMapper footballerMapper() {
        return new ModelMapper();
    }

    @Bean("positionMapper")
    public ModelMapper positionMapper() {
        return new ModelMapper();
    }

    @Bean("characteristicMapper")
    public ModelMapper characteristicMapper() {
        return new ModelMapper();
    }
}
