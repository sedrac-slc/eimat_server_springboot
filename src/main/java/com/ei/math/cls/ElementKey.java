package com.ei.math.cls;

import com.ei.math.entity.Group;
import com.ei.math.entity.UserPeople;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ElementKey implements Serializable {

   @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPeople userPeople;
    
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group; 
}
