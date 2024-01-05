package alpha1.o.com.genericeventmgtsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String name;

    private String description;

    private String image;

    private int capacity;


    @Enumerated(EnumType.STRING)
    private EventStatus status;

    public enum EventStatus {
        DRAFT, PUBLISHED, CLOSED
    }
}
