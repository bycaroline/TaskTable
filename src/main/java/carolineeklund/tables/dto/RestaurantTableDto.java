package carolineeklund.tables.dto;

import carolineeklund.tables.model.RestaurantTable;

public class RestaurantTableDto {
    private Long id;

    private int number_of_seats;

    private boolean reserved;

    public RestaurantTableDto(RestaurantTable restaurantTable){
        this.id= restaurantTable.getId();
        this.number_of_seats= restaurantTable.getNumber_of_seats();
        this.reserved= restaurantTable.isReserved();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
