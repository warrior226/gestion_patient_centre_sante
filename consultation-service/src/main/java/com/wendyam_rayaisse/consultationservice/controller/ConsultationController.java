package com.wendyam_rayaisse.consultationservice.controller;


import com.wendyam_rayaisse.consultationservice.constants.ConsultationConstants;
import com.wendyam_rayaisse.consultationservice.dto.ConsultationDto;
import com.wendyam_rayaisse.consultationservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.consultationservice.dto.ResponseDto;
import com.wendyam_rayaisse.consultationservice.service.IConsultationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "REST APIs pour le microservice Consultation",
        description = "REST APIs pour le microservice Consultation"
)
@RestController
@AllArgsConstructor
@Validated
@RequestMapping(path="/api",produces={MediaType.APPLICATION_JSON_VALUE})
public class ConsultationController {

    private IConsultationService iConsultationService;

    @Operation(
            summary = "Api pour la création d'une consultation",
            description="Api permettant de créer une consultation"
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
    public ResponseEntity<ResponseDto> createConsultation(@Valid @RequestBody ConsultationDto consultationDto){
        iConsultationService.createConsultation(consultationDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ConsultationConstants.STATUS_201,ConsultationConstants.MESSAGE_201));
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
    public ResponseEntity<List<ConsultationDto>> fetchConsultationfoDetails(@RequestParam int userId){
        List<ConsultationDto> listconsultationDto =iConsultationService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(listconsultationDto);
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
    public ResponseEntity<ResponseDto> updateConsultationDetail(@Valid @RequestBody ConsultationDto consultationDto){
        boolean isUpdated= iConsultationService.updateConsultation(consultationDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ConsultationConstants.STATUS_200,ConsultationConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ConsultationConstants.STATUS_417,ConsultationConstants.MESSAGE_417_UPDATE));

        }
    }


    @Operation(
            summary = "Api pour la suppression des informations d'une consultation",
            description="Api permettant de supprimer le compte d'une consultation"
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
    public ResponseEntity<ResponseDto> deleteConsultationInfoDetails(@RequestParam int consultationId){
        boolean isDeleted= iConsultationService.deleteConsultation(consultationId);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ConsultationConstants.STATUS_200,ConsultationConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ConsultationConstants.STATUS_417,ConsultationConstants.MESSAGE_417_DELETE));

        }
    }


    @Operation(
            summary = "Api pour rechercher les consultations d'un patient",
            description="Api permettant de rechercher les informations sur toutes les consultations d'un patient"
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
    @GetMapping("/fetchAll")
    public ResponseEntity<List<ConsultationDto>> fetchAllConsultationfoDetails(@RequestParam int userId){
        List<ConsultationDto> consultationDto =iConsultationService.getAllConsultation(userId);
        return ResponseEntity.status(HttpStatus.OK).body(consultationDto);
    }




}
