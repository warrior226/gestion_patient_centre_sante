package com.wendyam_rayaisse.rdvservice.controller;


import com.wendyam_rayaisse.rdvservice.constants.RdvConstants;
import com.wendyam_rayaisse.rdvservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.rdvservice.dto.RdvDto;
import com.wendyam_rayaisse.rdvservice.dto.ResponseDto;
import com.wendyam_rayaisse.rdvservice.service.IRdvService;
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
@AllArgsConstructor
@Validated
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RdvController {

    private IRdvService iRdvService;
    @Operation(
            summary = "Creation Rdv",
            description = "REST API to create Rdv"
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
    public ResponseEntity<ResponseDto> createRdv(@Valid @RequestBody RdvDto rdvDto){
        iRdvService.createRdv(rdvDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(RdvConstants.STATUS_201,RdvConstants.MESSAGE_201));
    }


    @Operation(
            summary = "delete rdv",
            description = "REST API to delete rdv"
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
    public ResponseEntity<ResponseDto> deleteRdv( @RequestParam int rdvId){
        boolean isDeleted= iRdvService.deleteByRdvId(rdvId);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(RdvConstants.STATUS_200,RdvConstants.MESSAGE_200));

        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(RdvConstants.STATUS_417,RdvConstants.MESSAGE_417_DELETE));
        }
    }

    @Operation(
            summary = "recherche l'ensemble des rdv chez un patient",
            description = "REST API to fetch list of rdv"
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
    public ResponseEntity<List<RdvDto>> fetchRdvListByUserId(@RequestParam int userId){
        List<RdvDto> rdvDto=iRdvService.findByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(rdvDto);
    }


    @Operation(
            summary = "update rdv",
            description = "REST API to update rdv"
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
    public ResponseEntity<ResponseDto> updateRdv( @Valid @RequestBody RdvDto rdvDto ){
        boolean isUpdated= iRdvService.updateRdv(rdvDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(RdvConstants.STATUS_200,RdvConstants.MESSAGE_200));

        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(RdvConstants.STATUS_417,RdvConstants.MESSAGE_417_UPDATE));
        }
    }

}
