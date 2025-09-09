package com.wendyam_rayaisse.resultatservice.service;

import com.wendyam_rayaisse.resultatservice.dto.ResultatDto;
import org.apache.logging.log4j.message.ReusableMessage;

import java.util.List;

public interface IResultatService {

    /**
     *
     * @param resultatDto
     */
    void createResultat(ResultatDto resultatDto);

    /**
     *
     * @param resultatDto
     * @return
     */
    boolean updateResultat(ResultatDto resultatDto);

    /**
     *
     * @param examenId
     * @return
     */
    boolean deleteResultat(int examenId);

    /**
     *
     * @param examenId
     * @return
     */
    List<ResultatDto> getAllResultat(int examenId);
}
