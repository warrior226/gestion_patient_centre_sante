package com.wendyam_rayaisse.constanteservice.controller;


import com.wendyam_rayaisse.constanteservice.constants.ConstantesConstants;
import com.wendyam_rayaisse.constanteservice.dto.ConstanteDto;
import com.wendyam_rayaisse.constanteservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.constanteservice.dto.ResponseDto;
import com.wendyam_rayaisse.constanteservice.service.IConstanteService;
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
        name = "REST APIs pour le microservice Constantes",
        description = "REST APIs pour le microservice Constantes"
)
@RestController
@AllArgsConstructor
@Validated
@RequestMapping(path ="/api",produces ={MediaType.APPLICATION_JSON_VALUE} )
public class ConstanteController {
    private  IConstanteService constanteService;

    @Operation(
            summary = "Creation de constantes",
            description = "REST API to create constante"
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
    public ResponseEntity<ResponseDto> createConstante(@Valid @RequestBody ConstanteDto constanteDto){
        constanteService.createConstanteInfo(constanteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ConstantesConstants.STATUS_201,ConstantesConstants.MESSAGE_201));
    }



    @Operation(
            summary = "update constante",
            description = "REST API to update constante"
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
    public ResponseEntity<ResponseDto> updateConstante( @Valid @RequestBody ConstanteDto constanteDto){
        boolean isUpdated=constanteService.updateConstanteInfo(constanteDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ConstantesConstants.STATUS_200,ConstantesConstants.MESSAGE_200));

        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(ConstantesConstants.STATUS_417,ConstantesConstants.MESSAGE_417_DELETE));
        }
    }



    @Operation(
            summary = "delet constante",
            description = "REST API to delete constante"
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
    public ResponseEntity<ResponseDto> deleteConstante( int patientId){
        boolean isDeleted=constanteService.deleteConstanteInfo(patientId);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ConstantesConstants.STATUS_200,ConstantesConstants.MESSAGE_200));

        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(ConstantesConstants.STATUS_417,ConstantesConstants.MESSAGE_417_DELETE));
        }
    }





}
