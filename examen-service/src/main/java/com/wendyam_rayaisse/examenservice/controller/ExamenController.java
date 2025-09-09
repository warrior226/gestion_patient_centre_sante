package com.wendyam_rayaisse.examenservice.controller;


import com.wendyam_rayaisse.examenservice.constants.ExamenConstants;
import com.wendyam_rayaisse.examenservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.examenservice.dto.ExamenDto;
import com.wendyam_rayaisse.examenservice.dto.ResponseDto;
import com.wendyam_rayaisse.examenservice.service.IExamenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api",produces={MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ExamenController {
    private IExamenService iExamenService;




    @Operation(
            summary = "Api pour la création d'une fiche d'examen pour un patient",
            description="Api permettant de créer une fiche d'examen pour un patient"
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
    public ResponseEntity<ResponseDto> createExamen(ExamenDto examenDto){
        iExamenService.createExamen(examenDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ExamenConstants.STATUS_201,ExamenConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Api pour la modification des informations d'un examen",
            description="Api permettant de modifier les informatons d'un examen"
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
    public ResponseEntity<ResponseDto> updateExamenInfo(@Valid @RequestBody ExamenDto examenDto){
        boolean isUpdated= iExamenService.updateExamen(examenDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ExamenConstants.STATUS_200,ExamenConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ExamenConstants.STATUS_417,ExamenConstants.MESSAGE_417_UPDATE));

        }
    }


    @Operation(
            summary = "Api pour la suppression des informations d'un examen",
            description="Api permettant de supprimer les informations d'un examen"
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
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteExamenDetails(@RequestParam int consultationId){
        boolean isDeleted= iExamenService.deleteExamen(consultationId);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ExamenConstants.STATUS_200,ExamenConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ExamenConstants.STATUS_417,ExamenConstants.MESSAGE_417_DELETE));

        }
    }


    @Operation(
            summary = "Api pour rechercher les informations d'un patient",
            description="Api permettant de rechercher les informations d'un patient"
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
    public ResponseEntity<List<ExamenDto>> fetchExamenByConsultationId(@RequestParam int consultationId){
        List<ExamenDto> examenDtoList=iExamenService.getAllExamen(consultationId);
        return ResponseEntity.status(HttpStatus.OK).body(examenDtoList);
    }




}
