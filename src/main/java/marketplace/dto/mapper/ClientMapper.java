package marketplace.dto.mapper;

import ch.qos.logback.core.net.server.Client;
import marketplace.dto.clientDto.ClientResponseDto;

public interface ClientMapper {
    ClientResponseDto toDto(Client client);
}
