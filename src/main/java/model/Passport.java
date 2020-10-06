package model;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Passport {
//    Passport с полями:
//    - серия;
//    - номер;
//    - имя владельца;
//    - год рождения;
//    - страна.

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String series;

    @NonNull
    private int number;

    @NonNull
    private String holderName;

    @NonNull
    private int year;

    @NonNull
    private String country;

}
