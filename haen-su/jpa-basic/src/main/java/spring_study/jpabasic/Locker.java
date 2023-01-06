package spring_study.jpabasic;

import javax.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "locker_Id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
