#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ${package}.persistence.jpa.model.ItemJpa;

public interface ItemJpaRepository extends JpaRepository<ItemJpa, Long>, JpaSpecificationExecutor<Long> {

}
