package com.wendyam_rayaisse.patient_medecinservice.controller;


import com.wendyam_rayaisse.patient_medecinservice.constants.UserConstants;
import com.wendyam_rayaisse.patient_medecinservice.dto.ErrorResponseDto;
import com.wendyam_rayaisse.patient_medecinservice.dto.ResponseDto;
import com.wendyam_rayaisse.patient_medecinservice.dto.UserDto;
import com.wendyam_rayaisse.patient_medecinservice.service.IUserService;
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
        name = "CRUD REST APIs pour le microservice user",
        description = "CRUD REST APIs pour le microservice user"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class UserController {

    private IUserService iUserService;



    @Operation(
            summary = "Create User REST API",
            description = "REST API to create User"
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
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UserDto userDto){
        iUserService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(UserConstants.STATUS_201,UserConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Create User REST API",
            description = "REST API to create User"
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
    @DeleteMapping("/deleteByPatientId")
    public ResponseEntity<ResponseDto> deleteByPatientId(@RequestParam int patientId){
        boolean isDeleted=iUserService.deleteByPatientId(patientId);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(UserConstants.STATUS_200,UserConstants.STATUS_201));
        }else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(UserConstants.STATUS_417,UserConstants.MESSAGE_417_DELETE));

        }
    }

    @Operation(
            summary = "Create User REST API",
            description = "REST API to create User"
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
    @DeleteMapping("/deleteByMedecinId")
    public ResponseEntity<ResponseDto> deleteByMedecinId(@RequestParam int medecinId){
        boolean isDeleted=iUserService.deleteByMedecinId(medecinId);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(UserConstants.STATUS_200,UserConstants.STATUS_201));
        }else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(UserConstants.STATUS_417,UserConstants.MESSAGE_417_DELETE));

        }
    }


}
