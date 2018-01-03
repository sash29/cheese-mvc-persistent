package org.launchcode.models.data;

import org.launchcode.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
//CR is a parameterized Spring interface which will accept & store Category object and the primary key of that object is Integer
//We cant use primitive 'int' within this context, hence wrapper class 'Integer' is used
public interface CategoryDao extends CrudRepository <Category,Integer>{
}
