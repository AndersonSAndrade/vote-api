package com.ads.voteapi.domain.mapper;

import com.ads.voteapi.domain.dto.ResultVoteDTO;
import com.ads.voteapi.domain.dto.SessionDTO;
import com.ads.voteapi.domain.entity.ResultVote;
import com.ads.voteapi.domain.entity.Session;
import org.modelmapper.ModelMapper;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, terça-feira
 **/
public class ResultVoteMapper {
    private final ModelMapper modelMapper;

    public ResultVoteMapper() {
        modelMapper = new ModelMapper();
    }

    /**
     * Converted ResultVote para ResultVoteDTO
     * @param entity
     * @return ResultVoteDTO
     * @author Anderson S. Andrade
     */
    public ResultVoteDTO entityToDto(ResultVote entity) {
        return modelMapper.map(entity, ResultVoteDTO.class);
    }

    /**
     * Converted ResultVoteDTO para ResultVote
     * @param dto
     * @return ResultVoteDTO
     * @author Anderson S. Andrade
     */
    public ResultVote dtoToEntity(ResultVoteDTO dto) {
        return modelMapper.map(dto, ResultVote.class);
    }
}
