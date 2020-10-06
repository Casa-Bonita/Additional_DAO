package model;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Client {
//    Client с полями:
//    - имя;
//    - номер договора;
//    - баланс на счету.

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String contractNumber;

    @NonNull
    private int balance;

}
