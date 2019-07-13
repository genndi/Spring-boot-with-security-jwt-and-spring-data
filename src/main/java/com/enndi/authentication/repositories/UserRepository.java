/**
 * 
 */
package com.enndi.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enndi.authentication.model.User;

/**
 * @author gustavo
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Transactional(readOnly = true)
	public User findByLogin(String login);

}
