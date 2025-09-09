package com.wendyam_rayaisse.disponibiliteservice.controller;


import com.wendyam_rayaisse.disponibiliteservice.constants.DisponibiliteConstants;
import com.wendyam_rayaisse.disponibiliteservice.dto.DisponibiliteDto;
import com.wendyam_rayaisse.disponibiliteservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.disponibiliteservice.dto.ResponseDto;
import com.wendyam_rayaisse.disponibiliteservice.service.IDisponibiliteService;
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
        name = "REST APIs pour le microservice Disponibilite",
        description = "REST APIs pour le microservice Disponibilite"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class DisponibiliteController {
    private IDisponibiliteService iDisponibiliteService;


    @Operation(
            summary = "Creation disponibilite permettant au medecin de renseigner les jours disponible",
            description = "REST API to create disponibilite"
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
    public ResponseEntity<ResponseDto> createDisponibilite(@Valid @RequestBody DisponibiliteDto disponibiliteDto){
        iDisponibiliteService.createDisponibilite(disponibiliteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(DisponibiliteConstants.STATUS_201,DisponibiliteConstants.MESSAGE_201));
    }



    @Operation(
            summary = "fetch disponibilite pour rechercher un medecin selon selon son id",
            description = "REST API to fetch disponibilite"
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
    @GetMapping("/fetch")
    public ResponseEntity<List<DisponibiliteDto>> fetchDisponibiliteByMedecinId(@RequestParam int medecinId){
        List<DisponibiliteDto> disponibiliteDto=iDisponibiliteService.fetchDisponibiliteByMedecinId(medecinId);
        return ResponseEntity.status(HttpStatus.OK).body(disponibiliteDto);
    }


    @Operation(
            summary = "update disponibilite",
            description = "REST API to fetch disponibilite"
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
    @PostMapping("/update")
    public ResponseEntity<ResponseDto> updateDisponibilite(@Valid @RequestBody DisponibiliteDto disponibiliteDto){
        boolean isUpdated= iDisponibiliteService.updateDisponibilite(disponibiliteDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(DisponibiliteConstants.STATUS_200,DisponibiliteConstants.MESSAGE_200));

        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(DisponibiliteConstants.STATUS_417,DisponibiliteConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "delete disponibilite",
            description = "REST API to delete disponibilite"
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
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteDisponibilite( @RequestParam int disponibiliteId){
        boolean isDeleted= iDisponibiliteService.deleteDispobibiliteByDisponibiliteId(disponibiliteId);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(DisponibiliteConstants.STATUS_200,DisponibiliteConstants.MESSAGE_200));

        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(DisponibiliteConstants.STATUS_417,DisponibiliteConstants.MESSAGE_417_DELETE));
        }
    }

}
