package com.wendyam_rayaisse.medecinservice.controller;


import com.wendyam_rayaisse.medecinservice.constants.MedecinConstants;
import com.wendyam_rayaisse.medecinservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.medecinservice.dto.MedecinDto;
import com.wendyam_rayaisse.medecinservice.dto.ResponseDto;
import com.wendyam_rayaisse.medecinservice.entity.Medecin;
import com.wendyam_rayaisse.medecinservice.service.IMedecinService;
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
        name = "REST APIs pour le microservice medecin",
        description = "REST APIs pour le microservice medecin"
)
@RestController
@RequestMapping(path="/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class MedecinController {

    private IMedecinService iMedecinService;

    @Operation(
            summary = "Api pour la création de compte d'un médécin",
            description="Api permettant de créer un compte pour un médécin"
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
    public ResponseEntity<ResponseDto> createMedecinCompte(@Valid @RequestBody MedecinDto medecinDto){
        iMedecinService.createMedecin(medecinDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MedecinConstants.STATUS_201,MedecinConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Api pour rechercher les informations d'un medecin à travers son id",
            description="Api permettant de rechercher les informations d'un médécin à travers son id "
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
    @GetMapping("/fetchById")
    public ResponseEntity<MedecinDto> fetchMedecinInfoDetailsById(@RequestParam int medecinId){
        MedecinDto medecinDto =iMedecinService.getMedecinById(medecinId);
        return ResponseEntity.status(HttpStatus.OK).body(medecinDto);
    }

    @Operation(
            summary = "Api pour rechercher les informations d'un medecin à travers son matricule",
            description="Api permettant de rechercher les informations d'un médécin à travers son matricule "
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
    @GetMapping("/fetchByMatricule")
    public ResponseEntity<MedecinDto> fetchMedecinInfoDetailsByMatricule(@RequestParam String matricule){
        MedecinDto medecinDto =iMedecinService.getMedecinByMatricule(matricule);
        return ResponseEntity.status(HttpStatus.OK).body(medecinDto);
    }


    @Operation(
            summary = "Api pour la modification des informations d'un médécin",
            description="Api permettant de modifier le compte d'un médécin"
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
    public ResponseEntity<ResponseDto> updateMedecinDetail(@Valid @RequestBody MedecinDto medecinDto){
        boolean isUpdated=iMedecinService.updateMedecin(medecinDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(MedecinConstants.STATUS_200,MedecinConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(MedecinConstants.STATUS_417,MedecinConstants.MESSAGE_417_UPDATE));

        }
    }



    @Operation(
            summary = "Api pour la suppression des informations d'un medecin",
            description="Api permettant de supprimer le compte d'un medecin"
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
    @DeleteMapping("/deleteById")
    public ResponseEntity<ResponseDto> deleteMedecinInfoDetailsById(@RequestParam int medecinId){
        boolean isDeleted=iMedecinService.deleteMedecinById(medecinId);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(MedecinConstants.STATUS_200,MedecinConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(MedecinConstants.STATUS_417,MedecinConstants.MESSAGE_417_DELETE));

        }
    }


    @Operation(
            summary = "Api pour la suppression des informations d'un medecin",
            description="Api permettant de supprimer le compte d'un medecin"
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
    @DeleteMapping("/deleteByMatricule")
    public ResponseEntity<ResponseDto> deleteMedecinInfoDetailsByMatricule(@RequestParam String matricule ){
        boolean isDeleted=iMedecinService.deleteMedecinByMatricule(matricule);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(MedecinConstants.STATUS_200,MedecinConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(MedecinConstants.STATUS_417,MedecinConstants.MESSAGE_417_DELETE));

        }
    }

}
