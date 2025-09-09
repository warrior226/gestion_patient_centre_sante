package com.wendyam_rayaisse.prescriptionservice.controller;


import com.wendyam_rayaisse.prescriptionservice.constants.PrescriptionConstants;
import com.wendyam_rayaisse.prescriptionservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.prescriptionservice.dto.PrescriptionDto;
import com.wendyam_rayaisse.prescriptionservice.dto.ResponseDto;
import com.wendyam_rayaisse.prescriptionservice.service.IPrescriptionService;
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
public class PrescriptionController {
    private IPrescriptionService iPrescriptionService;


    @Operation(
            summary = "Api pour la création d'une fiche de prescription pour un patient",
            description="Api permettant de créer une fiche de prescriptio pour un patient"
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
    public ResponseEntity<ResponseDto> createPrescription(PrescriptionDto prescriptionDto){
        iPrescriptionService.createPrescription(prescriptionDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(PrescriptionConstants.STATUS_201,PrescriptionConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Api pour la modification des informations de prescription d'un examen",
            description="Api permettant de modifier les informatons d eprescriptions d'un examen"
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
    public ResponseEntity<ResponseDto> updatePrescriptionInfo(@Valid @RequestBody PrescriptionDto prescriptionDto){
        boolean isUpdated= iPrescriptionService.updatePrescription(prescriptionDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(PrescriptionConstants.STATUS_200,PrescriptionConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(PrescriptionConstants.STATUS_417,PrescriptionConstants.MESSAGE_417_UPDATE));

        }
    }


    @Operation(
            summary = "Api pour la suppression des informations d'une prescription",
            description="Api permettant de supprimer les informations d'une prescription"
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
    public ResponseEntity<ResponseDto> deletePrescriptionDetails(@RequestParam int consultationId){
        boolean isDeleted= iPrescriptionService.deletePrescription(consultationId);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(PrescriptionConstants.STATUS_200,PrescriptionConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(PrescriptionConstants.STATUS_417,PrescriptionConstants.MESSAGE_417_DELETE));

        }
    }

    @Operation(
            summary = "Api pour rechercher les informations d'une prescription",
            description="Api permettant de rechercher les informations d'une prescription"
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
    public ResponseEntity<List<PrescriptionDto>> fetchExamenByConsultationId(@RequestParam int consultationId){
        List<PrescriptionDto> prescriptionDtoList=iPrescriptionService.getAllPrescription(consultationId);
        return ResponseEntity.status(HttpStatus.OK).body(prescriptionDtoList);
    }


}
