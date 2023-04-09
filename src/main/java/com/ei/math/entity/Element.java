package com.ei.math.entity;

import com.ei.math.cls.ElementId;
import com.ei.math.cls.ElementKey;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_element")
//@IdClass(ElementId.class)
public class Element implements Serializable{
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Type(type = "uuid-char")
    //@Column(columnDefinition = "varchar(40) default (select uuid())",unique = true)
    //private UUID id;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPeople userPeople;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;  
    
    @Column(columnDefinition = "datetime default now()")
    private LocalDateTime createdAt;
    
}
