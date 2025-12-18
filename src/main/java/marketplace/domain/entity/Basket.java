package marketplace.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Basket {
    private int client_id;
    private int product_id;
    private int quantity;

}
