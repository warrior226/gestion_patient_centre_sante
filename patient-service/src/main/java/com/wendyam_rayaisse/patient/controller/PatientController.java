package com.wendyam_rayaisse.patient.controller;


import com.wendyam_rayaisse.patient.constants.PatientConstants;
import com.wendyam_rayaisse.patient.dto.ErrorResponseDto;
import com.wendyam_rayaisse.patient.dto.PatientDto;
import com.wendyam_rayaisse.patient.dto.ResponseDto;
import com.wendyam_rayaisse.patient.service.IPatientService;
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


@Tag(
        name = "REST APIs pour le microservice Patient",
        description = "REST APIs pour le microservice Patient"
)
@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class PatientController {

    private IPatientService iPatientService;


    @Operation(
            summary = "Api pour la création de compte d'un patient",
            description="Api permettant de créer un compte pour un patient"
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
    public ResponseEntity<ResponseDto> createPatientCompte(@Valid @RequestBody PatientDto patientDto){
        iPatientService.createPatient(patientDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(PatientConstants.STATUS_201,PatientConstants.MESSAGE_201));
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
    public ResponseEntity<ResponseDto> updatePatientDetail(@Valid @RequestBody PatientDto patientDto){
        boolean isUpdated=iPatientService.updatePatient(patientDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(PatientConstants.STATUS_200,PatientConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(PatientConstants.STATUS_417,PatientConstants.MESSAGE_417_UPDATE));

        }
    }


    @Operation(
            summary = "Api pour la suppression des informations d'un patient",
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
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deletePatientInfoDetails(@RequestParam String matricule){
        boolean isDeleted=iPatientService.deletePatientByMatricule(matricule);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(PatientConstants.STATUS_200,PatientConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(PatientConstants.STATUS_417,PatientConstants.MESSAGE_417_UPDATE));

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
    public ResponseEntity<PatientDto> fetchPatientInfoDetails(@RequestParam String matricule){
        PatientDto patientDto =iPatientService.getPatientByMatricule(matricule);
        return ResponseEntity.status(HttpStatus.OK).body(patientDto);
    }



}
