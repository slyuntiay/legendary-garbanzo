package marketplace.dto.mapper;

import ch.qos.logback.core.net.server.Client;
import marketplace.dto.clientDto.ClientRequestDto;
import marketplace.dto.clientDto.ClientResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientResponseDto toResponse(Client client);
    Client toEntity(ClientRequestDto requestDto);
}