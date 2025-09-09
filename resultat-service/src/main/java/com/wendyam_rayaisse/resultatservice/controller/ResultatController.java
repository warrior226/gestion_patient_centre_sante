package com.wendyam_rayaisse.resultatservice.controller;


import com.wendyam_rayaisse.resultatservice.constants.ResultatConstants;
import com.wendyam_rayaisse.resultatservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.resultatservice.dto.ResponseDto;
import com.wendyam_rayaisse.resultatservice.dto.ResultatDto;
import com.wendyam_rayaisse.resultatservice.entity.Resultat;
import com.wendyam_rayaisse.resultatservice.service.IResultatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "REST APIs pour le microservice Resultat",
        description = "REST APIs pour le microservice Resultat"
)
@RestController
@AllArgsConstructor
@Validated
public class ResultatController {
    private IResultatService iResultatService;

    @Operation(
            summary = "Creation Resultat d'un patient ",
            description = "REST API to create Resultat d'un patient"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createResultat(@Valid @RequestBody ResultatDto resultatDto){
        iResultatService.createResultat(resultatDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ResultatConstants.STATUS_201,ResultatConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Api pour la modification des informations d'un patient",
            description="Api permettant de modifier le compte d'un patient"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/update")
    public ResponseEntity<ResponseDto> updateResultatDetail(@Valid @RequestBody ResultatDto resultatDto){
        boolean isUpdated= iResultatService.updateResultat(resultatDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ResultatConstants.STATUS_200,ResultatConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ResultatConstants.STATUS_417,ResultatConstants.MESSAGE_417_UPDATE));

        }
    }


    @Operation(
            summary = "Api pour la suppresion des informations d'un patient",
            description="Api permettant de supprimer le compte d'un patient"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/delete")
    public ResponseEntity<ResponseDto> deleteResultatDetail(@RequestParam int examenId){
        boolean isDeleted= iResultatService.deleteResultat(examenId);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ResultatConstants.STATUS_200,ResultatConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ResultatConstants.STATUS_417,ResultatConstants.MESSAGE_417_UPDATE));

        }
    }


    @Operation(
            summary = "Api pour rechercher l'ensemble des resultats d'un examen",
            description="Api permettant de rechercher l'ensemble des resultats d'un examen"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetch")
    public ResponseEntity<List<ResultatDto>> fetchResultatByExamenId(@RequestParam int examenId){
        List<ResultatDto> resultatDtoList=iResultatService.getAllResultat(examenId);
        return ResponseEntity.status(HttpStatus.OK).body(resultatDtoList);
    }


}
