package cn.tuyucheng.taketoday.serializeentityid;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}