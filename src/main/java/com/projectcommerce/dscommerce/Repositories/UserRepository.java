package com.projectcommerce.dscommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectcommerce.dscommerce.entities.User;
import com.projectcommerce.dscommerce.projections.UserDetailsProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = """
			SELECT TB_USER.email AS username, TB_USER.password, TB_ROLE.id AS roleId, TB_ROLE.authority
			FROM TB_USER
			INNER JOIN TB_USER_ROLE ON TB_USER.id = TB_USER_ROLE.user_id
			INNER JOIN TB_ROLE ON TB_ROLE.id = TB_USER_ROLE.role_id
			WHERE TB_USER.email = :email
		""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
}
