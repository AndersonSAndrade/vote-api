package com.ads.voteapi.api.resource;

import com.ads.voteapi.api.events.ResourceCreatingEvent;
import com.ads.voteapi.common.presenter.ResultPresenter;
import com.ads.voteapi.common.param.OpenSessionParam;
import com.ads.voteapi.domain.dto.SessionDTO;
import com.ads.voteapi.domain.dto.VoteDTO;
import com.ads.voteapi.services.interfaces.SessionService;
import com.ads.voteapi.services.interfaces.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/v1/session")
@CrossOrigin("*")
public class SessionResource {

    private final SessionService sessionService;
    private final VoteService voteService;
    private final ApplicationEventPublisher publisher;

    @Operation(summary = "GET ALL SESSION", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SessionDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)})
    @GetMapping
    public ResponseEntity<List<SessionDTO>> findAll(){
        List<SessionDTO> sessionDTOS = sessionService.findAll();
        return ResponseEntity.ok().body(sessionDTOS);
    }

    @Operation(summary = "GET SESSION BY ID", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SessionDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<SessionDTO> findById(@PathVariable("id") Long id) {
        SessionDTO sessionDTO = sessionService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(sessionDTO);
    }

    @Operation(summary = "POST SESSION SAVED", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SessionDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)})
    @PostMapping("/opening")
    public ResponseEntity<SessionDTO> openingSession(@Validated @RequestBody OpenSessionParam dto, HttpServletResponse response) {
        SessionDTO sessionDTO = sessionService.openingSession(dto);
        publisher.publishEvent(new ResourceCreatingEvent(this, response, sessionDTO.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionDTO);
    }

    @Operation(summary = "POST MAKING VOTE", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultPresenter.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)})
    @PostMapping("/voting")
    public ResponseEntity<ResultPresenter> voting(@Validated @RequestBody VoteDTO dto) {
        ResultPresenter result = voteService.voting(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
