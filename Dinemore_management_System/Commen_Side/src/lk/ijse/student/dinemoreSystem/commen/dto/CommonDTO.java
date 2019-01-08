package lk.ijse.student.dinemoreSystem.commen.dto;

public class CommonDTO extends SuperDTO {
    CustomerDTO customerDTO;
    PlaceOrderDTO placeOrderDTO;

    public CommonDTO() {
    }

    public CommonDTO(CustomerDTO customerDTO, PlaceOrderDTO placeOrderDTO) {
        this.customerDTO = customerDTO;
        this.placeOrderDTO = placeOrderDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public PlaceOrderDTO getPlaceOrderDTO() {
        return placeOrderDTO;
    }

    public void setPlaceOrderDTO(PlaceOrderDTO placeOrderDTO) {
        this.placeOrderDTO = placeOrderDTO;
    }
}
