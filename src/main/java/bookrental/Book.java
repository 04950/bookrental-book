package bookrental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Book_table")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long rentId;
    private String status;
    private String description;
    private String bookName;
    private Double price;

    @PostPersist
    public void onPostPersist(){
        RentalRegistered rentalRegistered = new RentalRegistered();
        BeanUtils.copyProperties(this, rentalRegistered);
        rentalRegistered.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        BookRented bookRented = new BookRented();
        BeanUtils.copyProperties(this, bookRented);
        bookRented.publishAfterCommit();


    }

    @PreUpdate
    public void onPreUpdate(){
        BookRentCanceled bookRentCanceled = new BookRentCanceled();
        BeanUtils.copyProperties(this, bookRentCanceled);
        bookRentCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }




}
