package marketplace.params;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ConnectionParams {

    private final String url;
    private final String user;
    private final String password;

}
