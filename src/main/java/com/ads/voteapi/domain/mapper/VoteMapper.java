package com.ads.voteapi.domain.mapper;

import com.ads.voteapi.domain.dto.VoteDTO;
import com.ads.voteapi.domain.entity.Vote;
import org.modelmapper.ModelMapper;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
public class VoteMapper {
    private final ModelMapper modelMapper;

    public VoteMapper() {
        modelMapper = new ModelMapper();
    }

    /**
     * Converted Vote para VoteDTO
     * @param entity
     * @return VoteDTO
     * @author Anderson S. Andrade
     */
    public VoteDTO entityToDto(Vote entity) {
        return modelMapper.map(entity, VoteDTO.class);
    }

    /**
     * Converted VoteDTO para Vote
     * @param dto
     * @return VoteDTO
     * @author Anderson S. Andrade
     */
    public Vote dtoToEntity(VoteDTO dto) {
        return modelMapper.map(dto, Vote.class);
    }
}
