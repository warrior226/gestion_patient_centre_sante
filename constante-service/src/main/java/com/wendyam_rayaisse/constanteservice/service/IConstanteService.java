package com.wendyam_rayaisse.constanteservice.service;

import com.wendyam_rayaisse.constanteservice.dto.ConstanteDto;

public interface
IConstanteService {

    void createConstanteInfo(ConstanteDto constanteDto);

    boolean updateConstanteInfo(ConstanteDto constanteDto);

    boolean deleteConstanteInfo(int constanteId);
}
