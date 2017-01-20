package com.zadora.repositories;

import com.zadora.dto.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adam on 06.01.17.
 */

public interface UserRepository extends CrudRepository<User, Long>{
}
