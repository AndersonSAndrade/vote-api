package com.ads.voteapi.api.resource;

import com.ads.voteapi.domain.dto.ScheduleDTO;
import com.ads.voteapi.services.interfaces.ScheduleService;
import com.ads.voteapi.shared.events.ResourceCreatingEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v1/schedule")
@CrossOrigin("*")
public class ScheduleResource {

    private final ScheduleService scheduleService;
    private final ApplicationEventPublisher publisher;

    @Operation(summary = "GET ALL SCHEDULES", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduleDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)})
    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> findAll(){
        List<ScheduleDTO> scheduleDTOS = scheduleService.findAll();
        return ResponseEntity.ok().body(scheduleDTOS);
    }

    @Operation(summary = "GET SCHEDULES BY ID", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduleDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> findById(@PathVariable("id") Long id) throws Exception {
        ScheduleDTO scheduleDTOS = scheduleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleDTOS);
    }

    @Operation(summary = "POST SCHEDULES SAVED", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduleDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)})
    @PostMapping("/save")
    public ResponseEntity<ScheduleDTO> save(@Valid @RequestBody ScheduleDTO dto, HttpServletResponse response) {
        ScheduleDTO scheduleDTO = scheduleService.save(dto);
        publisher.publishEvent(new ResourceCreatingEvent(this, response, scheduleDTO.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleDTO);
    }

}
